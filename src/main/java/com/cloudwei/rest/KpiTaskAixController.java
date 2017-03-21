package com.cloudwei.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.cloudwei.entity.TPatrolKpiTask;
import com.cloudwei.repository.HaGpfsResultReposity;
import com.cloudwei.repository.HaGpfsSetRepository;
import com.cloudwei.repository.TPatrolKpiTaskRepository;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/kpiTaskAix")
public class KpiTaskAixController {
	@Autowired
	private TPatrolKpiTaskRepository patrolKpiTaskRepository;
	@Autowired
	private HaGpfsResultReposity resultRepository;
	@Autowired
	private HaGpfsSetRepository setRepository;
	 
    @RequestMapping()
    public String getHaGpfsResult(
            @RequestParam(value = "patrolTime",defaultValue="")String patrolTime,
            @RequestParam(value="pageNum",defaultValue="0") int pageNum,
            @RequestParam(value="pageSize",defaultValue="10") int pageSize){
        PageRequest pageRequest = new PageRequest(pageNum,pageSize,Direction.DESC, "patrolTime");
        
        Page<TPatrolKpiTask> taskPages;
        if (StringUtils.isEmpty(patrolTime)) {
        	taskPages=patrolKpiTaskRepository.findAll("aix",pageRequest);
        }else{
        	 taskPages=patrolKpiTaskRepository.findByPatrolTimeStartingWith(patrolTime+"%", pageRequest);
        }
        List<TPatrolKpiTask> taskLists=taskPages.getContent();
 
        Gson gson=new Gson();
        JsonArray array=new JsonArray();
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("totalElements",taskPages.getTotalElements());
		jsonObject.addProperty("totalPages",taskPages.getTotalPages());
		jsonObject.addProperty("number",taskPages.getNumber());
		jsonObject.addProperty("size",taskPages.getSize());
		jsonObject.addProperty("numberOfElements",taskPages.getNumberOfElements());
		
		for(TPatrolKpiTask task:taskLists){
			JsonObject obj=new JsonObject();
			obj.addProperty("id", task.getId());
			obj.addProperty("ip", task.gettPatrolKpiTaskIp());
			
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
			
			array.add(obj);
		}
		jsonObject.add("content", array);
		
		return gson.toJson(jsonObject);
    }
    
    @RequestMapping("/detail")
	public String getDetail(@RequestParam(value = "taskID", defaultValue = "") long taskID){
		
		TPatrolKpiTask kpiTask=patrolKpiTaskRepository.findOne(taskID);
		
		Gson gson=new Gson();
		JsonObject jsonObject=new JsonObject();
		jsonObject.addProperty("ip", kpiTask.gettPatrolKpiTaskIp());
		
		String time=kpiTask.getPatrolTime();
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
		
		List<THaGpfsSet> setLists=setRepository.findByTHaGpfsSetType("6");
		 
		List<Long> setidString=new ArrayList<>();
		for(THaGpfsSet tHaGpfsSet : setLists){
			setidString.add(tHaGpfsSet.getId());
		}
		List<THaGpfsResults> resultLists=resultRepository.findByTHagpfsResultsSetIdInAndTHaGpfsResultsTaskId(setidString, taskID);
		System.out.println(resultLists.size());
		
		JsonArray array=new JsonArray();
		if(resultLists!=null&&resultLists.size()>0){
			for(THaGpfsResults result:resultLists){
				for(THaGpfsSet set:setLists){
					if(set.getId()==result.gettHagpfsResultsSetId()){
						JsonObject cache=new JsonObject();
						String resultValue=result.gettHaGpfsResultsShowvalue();
						
						cache.addProperty("setName", set.getTHaGpfsSet_NAME());
						if(resultValue.equals("OK")){
							if(result.gettHaGpfsResultsResult().contains("error")){
								cache.addProperty("setShow", "异常 : "+result.gettHaGpfsResultsResult().replaceAll("\n", "<br>"));
							}else{
								cache.addProperty("setShow", result.gettHaGpfsResultsResult().replaceAll("\n", "<br>"));
							}
						}else if(resultValue.equals("ERROR")){
							cache.addProperty("setShow","异常 ："+result.gettHaGpfsResultsResult().replaceAll("\n", "<br>"));
						}
						array.add(cache);
					}
				}
			}
		}else{
			JsonObject cache=new JsonObject();
			cache.addProperty("setName", "没有查询结果");
			cache.addProperty("setShow","无");
			array.add(cache);
		}
		jsonObject.add("content",array);
		return gson.toJson(jsonObject);
	}
}
