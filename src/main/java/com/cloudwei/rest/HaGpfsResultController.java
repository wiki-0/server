package com.cloudwei.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.cloudwei.entity.THaGpfsTask;
import com.cloudwei.repository.HaGpfsResultReposity;
import com.cloudwei.repository.HaGpfsSetRepository;
import com.cloudwei.repository.HaGpfsTaskRepository;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/haGpfsResult")
public class HaGpfsResultController {
	@Autowired
	private HaGpfsTaskRepository taskRepository;
	@Autowired
	private HaGpfsSetRepository setRepository;
	@Autowired
	private HaGpfsResultReposity haGpfsResultReposity;
	
	@RequestMapping
	public String getHaGpfsTask(
				@RequestParam(value = "patrolTime", defaultValue = "") String patrolTime,
	            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
	            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		
		Gson gson=new Gson();
		JsonArray array=new JsonArray();
		JsonObject jsonObject=new JsonObject();
		
		PageRequest pageRequest = new PageRequest(pageNum, pageSize,Direction.DESC, "patrolTime");
		
		Page<THaGpfsTask> taskPages;
		if (StringUtils.isEmpty(patrolTime)) {
			/*Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String today = format.format(date);
			fromPage = tPatrolMiniCpRepository.findByStatusAndResultTimeStartingWith(status, today, pageRequest);*/
			taskPages=taskRepository.findAll(pageRequest);
		}else{
			taskPages=taskRepository.findByPatrolTimeStartingWith(patrolTime+"%", pageRequest);
		}
		List<THaGpfsTask> taskLists=taskPages.getContent();
		System.out.println(taskLists.size());
		
		jsonObject.addProperty("totalElements",taskPages.getTotalElements());
		jsonObject.addProperty("totalPages",taskPages.getTotalPages());
		jsonObject.addProperty("number",taskPages.getNumber());
		jsonObject.addProperty("size",taskPages.getSize());
		jsonObject.addProperty("numberOfElements",taskPages.getNumberOfElements());
		
		for(THaGpfsTask task:taskLists){
			JsonObject obj=new JsonObject();
			obj.addProperty("id", task.getId());
			obj.addProperty("ip",task.gettHaGpfsTaskIp());
			
			String time=task.getPatrolTime();
			if(time!=null){
				DateFormat format = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				Date date=new Date();
				try {
					 date = format.parse(time);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			
				obj.addProperty("patrolTime",format.format(date));
			}else{
				obj.addProperty("patrolTime","--");
			}
			
			obj.addProperty("sysname", task.gettHaGpfsTaskSysname()+"(主)");
			
			if(task.gettHaGpfsTaskOrder().equals("1")){
				obj.addProperty("sysname", task.gettHaGpfsTaskSysname()+"(主)");
			}else if(task.gettHaGpfsTaskOrder().equals("2")){
				obj.addProperty("sysname", task.gettHaGpfsTaskSysname()+"(备)");
			}
			array.add(obj);
		}
		jsonObject.add("content", array);
		
		return gson.toJson(jsonObject);
			
	}
	
	
	@RequestMapping("/detail")
	public String getDetail(
			@RequestParam(value = "taskID", defaultValue = "") long taskID){
		THaGpfsTask task=taskRepository.findOne(taskID);
		List<THaGpfsResults> resultLists=haGpfsResultReposity.findByTHaGpfsResultsTaskId(taskID);
		List<THaGpfsSet> setLists=setRepository.findAll();
		
		Gson gson=new Gson();
		JsonObject jsonObject=new JsonObject();
		
		jsonObject.addProperty("id", task.getId());
		jsonObject.addProperty("ip",task.gettHaGpfsTaskIp());
		
		String time=task.getPatrolTime();
		if(time!=null){
			DateFormat format = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			Date date=new Date();
			try {
				 date = format.parse(time);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
			jsonObject.addProperty("patrolTime",format.format(date));
		}else{
			jsonObject.addProperty("patrolTime","--");
		}
		jsonObject.addProperty("sysname", task.gettHaGpfsTaskSysname()+"(主)");
		
		if(task.gettHaGpfsTaskOrder().equals("1")){
			jsonObject.addProperty("sysname", task.gettHaGpfsTaskSysname()+"(主)");
		}else if(task.gettHaGpfsTaskOrder().equals("2")){
			jsonObject.addProperty("sysname", task.gettHaGpfsTaskSysname()+"(备)");
		}
		
		JsonArray cacheArray=new JsonArray();
		
		for(THaGpfsResults result:resultLists){
			for(THaGpfsSet set:setLists){
				if(set.getId()==result.gettHagpfsResultsSetId()){
						JsonObject cache=new JsonObject();
						cache.addProperty("setName", set.getTHaGpfsSet_NAME());
						if(result.gettHaGpfsResultsShowvalue().equals("OK")){
							set.settHaGpfsSetShow("正常");
							cache.addProperty("setShow",set.gettHaGpfsSetShow());
						}else if(result.gettHaGpfsResultsShowvalue().equals("ERROR")){
							set.settHaGpfsSetShow("异常 ："+result.gettHaGpfsResultsResult().replaceAll("\n", "<br>"));
							cache.addProperty("setShow",set.gettHaGpfsSetShow());
						}
						else if (result.gettHaGpfsResultsShowvalue().equals("OKGPFS")) {
							cache.addProperty("setShow", "有GPFS");
						}
						else if (result.gettHaGpfsResultsShowvalue().equals("ERRORGPFS")) {
							cache.addProperty("setShow", "无GPFS");
						}else if(result.gettHaGpfsResultsShowvalue()!=null&& 
								result.gettHaGpfsResultsShowvalue().replaceAll("\r", "").length() > 20){
							cache.addProperty("setShow", result.gettHaGpfsResultsShowvalue().replaceAll("\r",""));
						}else{
							cache.addProperty("setShow", result.gettHaGpfsResultsShowvalue());
						}
						cacheArray.add(cache);
					}
				}
			}//end resultLists loop
		jsonObject.add("content", cacheArray);
		return gson.toJson(jsonObject);
	}
}

