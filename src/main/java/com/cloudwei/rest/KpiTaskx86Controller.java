package com.cloudwei.rest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudwei.entity.THaGpfsResults;
import com.cloudwei.entity.THaGpfsSet;
import com.cloudwei.entity.TPatrolKpiTask;
import com.cloudwei.repository.HaGpfsResultReposity;
import com.cloudwei.repository.HaGpfsSetRepository;
import com.cloudwei.repository.TPatrolKpiTaskRepository;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/kpiTaskx86")
public class KpiTaskx86Controller {
	@Autowired
	private TPatrolKpiTaskRepository patrolKpiTaskRepository;
	@Autowired
	private HaGpfsResultReposity resultRepository;
	@Autowired
	private HaGpfsSetRepository setRepository;

	@RequestMapping()
	public String getHaGpfsResult(@RequestParam(value = "patrolTime", defaultValue = "") String patrolTime,
			@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize)
					throws JsonParseException, JsonMappingException, IOException, ParseException {
		PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "patrolTime");
		Page<TPatrolKpiTask> page = patrolKpiTaskRepository.findAll("x86", pageRequest);

		if (!StringUtils.isEmpty(patrolTime)) {
			page = patrolKpiTaskRepository.findByTPatrolKpiTaskTypeAndPatrolTimeStartingWith("x86", patrolTime + "%",
					pageRequest);
		}

		List<TPatrolKpiTask> taskLists = page.getContent();
		Gson gson = new Gson();
		JsonArray array = new JsonArray();
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("totalElements", page.getTotalElements());
		jsonObject.addProperty("totalPages", page.getTotalPages());
		jsonObject.addProperty("number", page.getNumber());
		jsonObject.addProperty("size", page.getSize());
		jsonObject.addProperty("numberOfElements", page.getNumberOfElements());
		for (TPatrolKpiTask task : taskLists) {
			JsonObject obj = new JsonObject();
			obj.addProperty("id", task.getId());
			obj.addProperty("ip", task.gettPatrolKpiTaskIp());
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			obj.addProperty("patrolTime", format.format( format.parse(task.getPatrolTime())));
			array.add(obj);
		}
		jsonObject.add("content", array);
		return gson.toJson(jsonObject);
	}

	@RequestMapping("/detail")
	public String getDetail(@RequestParam(value = "taskID", defaultValue = "") long taskID) {
		TPatrolKpiTask kpiTask = patrolKpiTaskRepository.findOne(taskID);

		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("ip", kpiTask.gettPatrolKpiTaskIp());
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			jsonObject.addProperty("patrolTime", format.format(format.parse(kpiTask.getPatrolTime())));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<THaGpfsSet> setLists = setRepository.findByTHaGpfsSetType("7");

		List<Long> setidString = new ArrayList<>();
		for (THaGpfsSet tHaGpfsSet : setLists) {
			setidString.add(tHaGpfsSet.getId());
		}
		List<THaGpfsResults> resultLists = resultRepository
				.findByTHagpfsResultsSetIdInAndTHaGpfsResultsTaskId(setidString, taskID);
		JsonArray array = new JsonArray();
		jsonObject.addProperty("cpu", "通过管理口获得");
		jsonObject.addProperty("memory", "通过管理口获得");

		for (THaGpfsResults result : resultLists) {
			for (THaGpfsSet set : setLists) {
				if (set.getId() == result.gettHagpfsResultsSetId()) {
					JsonObject cache = new JsonObject();
					String resultValue = result.gettHaGpfsResultsShowvalue();

					cache.addProperty("setName", set.getTHaGpfsSet_NAME());
					cache.addProperty("showValue", resultValue);
					if (resultValue.equals("OK")) {
						if (set != null && !"".equals(result.gettHaGpfsResultsResult())) {
							if (set != null && set.gettHaGpfsSetCommand().contains("wmic logicaldisk")) {
								cache.addProperty("result", toGb(result.gettHaGpfsResultsResult()));
							} else {
								cache.addProperty("result", result.gettHaGpfsResultsResult().replaceAll("\n", "<br>"));

							}
						} else if (resultValue.equals("ERROR")) {
							if (result.gettHaGpfsResultsResult() != null
									&& !"".equals(result.gettHaGpfsResultsResult())) {
								if (set != null && set.gettHaGpfsSetCommand().contains("wmic logicaldisk")) {
									cache.addProperty("result",
											toGb(result.gettHaGpfsResultsResult()).replaceAll("\n", "<br>"));
								} else {
									cache.addProperty("result",
											result.gettHaGpfsResultsResult().replaceAll("\n", "<br>"));
								}

							}

						}
						array.add(cache);
					}
				}

			}
		}

		jsonObject.add("content", array);
		return gson.toJson(jsonObject);
	}

	public String toGb(String s) {
		String[] strs = s.split("\n");
		String text = new String();
		for (String str : strs) {
			// System.out.println("str=" +str);
			if (str != null && !"".equals(str) && !str.contains("Caption")) {
				text += "逻辑盘  ";
				String[] strings = str.split(" ");
				boolean flagFree = true;
				boolean flagSum = true;
				if (strings != null && strings.length > 0) {
					for (int i = 0; i < strings.length; i++) {
						// System.out.println(" strings "+i+" = " + strings[i]);
						if (i == 0) {
							text += strings[i];
						} else if (strings[i] != null && !"".equals(strings[i]) && flagFree) {
							try {
								long free = Long.parseLong(strings[i]);
								text += "空闲空间:" + (free / 1024 / 1024 / 1024) + " GB,";
								flagFree = false;
							} catch (Exception e) {

							}
						} else if (strings[i] != null && !"".equals(strings[i]) && flagSum) {
							long free = Long.parseLong(strings[i]);
							text += "总空间:" + (free / 1024 / 1024 / 1024) + " GB.";
							flagSum = false;
							break;
						}
					}
				}
			}
		}
		return text;
	}

}
