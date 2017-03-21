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

import com.cloudwei.entity.Result;
import com.cloudwei.entity.TBusinessType;
import com.cloudwei.repository.BusinessTypeRepository;
import com.cloudwei.repository.TPatrolMiniCpRepository;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@RestController
@RequestMapping("/patrolMiniCp")
public class TPatrolMiniCpController {

	@Autowired
	private TPatrolMiniCpRepository tPatrolMiniCpRepository;
	@Autowired
	private BusinessTypeRepository businessTypeRepository;
	
	@RequestMapping
	public String getResult(
			@RequestParam(value = "ip", defaultValue = "") String ip,
			@RequestParam(value = "patrolTime", defaultValue = "") String resultTime,
			@RequestParam(value = "resultType", defaultValue = "") String resultType,
			@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		
		PageRequest pageRequest = new PageRequest(pageNum, pageSize, Direction.DESC, "resultTime");
		Page<Result> pageResult=null;
		
		//如果时间不为空,
		if(!StringUtils.isEmpty(resultTime)){
					
			//如果ip不为空,巡检分类等于all
			if(!StringUtils.isEmpty(ip)&&resultType.equals("all")){
				pageResult=tPatrolMiniCpRepository.findByResultTimeAndNodeIp(resultTime+"%", ip, pageRequest);
			}
			//如果巡检分类不等于all,而且ip为空
			if(!resultType.equals("all")&&StringUtils.isEmpty(ip)){
				if(resultType.equals("ALARM")){
					pageResult=tPatrolMiniCpRepository.findByStatusAndResultTimeStartingWith("OK", resultTime+"%", pageRequest);
				}else if(resultType.equals("OK")){
					pageResult=tPatrolMiniCpRepository.findByStatusAndResultTimeStartingWith2("OK", resultTime+"%", pageRequest);
				}else if(resultType.equals("ERROR")){
					pageResult=tPatrolMiniCpRepository.findByResultTimeStartingWithAndStatus(resultTime+"%", "ERROR", pageRequest);
				}
			}
			//如果巡检分类不等于all 而且ip不为空
			if(!resultType.equals("all")&&!StringUtils.isEmpty(ip)){
				if(resultType.equals("ALARM")){
					pageResult=tPatrolMiniCpRepository.findByResultTimeStartingWithAndNodeIpAndStatus1(resultTime+"%", ip, "OK", pageRequest);
					System.out.println(pageResult.getTotalElements());
				}else if(resultType.equals("OK")){
					pageResult=tPatrolMiniCpRepository.findByResultTimeStartingWithAndNodeIpAndStatus2(resultTime+"%", ip, "OK", pageRequest);
				}else if(resultType.equals("ERROR")){
					pageResult=tPatrolMiniCpRepository.findByResultTimeStartingWithAndNodeIpAndStatus3(resultTime+"%", ip, "ERROR", pageRequest);
				}
			}
			//如果巡检分类等于all 而且ip为空
			if(StringUtils.isEmpty(ip)&&resultType.equals("all")){
				pageResult=tPatrolMiniCpRepository.findByResultTimeStartingWith(resultTime+"%", pageRequest);
			}
		}else{
			pageResult=tPatrolMiniCpRepository.findAll(pageRequest);
		}
		 
		Gson gson=new Gson();
		JsonArray array=new JsonArray();
		JsonObject jsonObject=new JsonObject();
		
		jsonObject.addProperty("totalElements",pageResult.getTotalElements());
		jsonObject.addProperty("totalPages",pageResult.getTotalPages());
		jsonObject.addProperty("number",pageNum+1);
		jsonObject.addProperty("size",pageSize);
		jsonObject.addProperty("numberOfElements",pageResult.getNumberOfElements());
		
		List<Result> resultSubLists = pageResult.getContent();
		
		if(resultSubLists!=null && resultSubLists.size()>0){
			for(Result result : resultSubLists){
				JsonObject obj=new JsonObject();
				obj.addProperty("id", result.getId());
				obj.addProperty("nodeName", result.getNode().gettResNodeSysName());
				
				String time=result.getResultTime();
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
				obj.addProperty("ip", result.getNode().getIp());
				obj.addProperty("status", result.getStatus());
				array.add(obj);
			}
		}
		jsonObject.add("content", array);
		
		return gson.toJson(jsonObject);
	}

	
	  @RequestMapping(value = "/{id}")
	    public String getDetail(@RequestParam(value = "id", defaultValue = "") Long id) {
		  	List<TBusinessType> businessLists= (List<TBusinessType>) businessTypeRepository.findAll();
	        Result result = tPatrolMiniCpRepository.findOne(id);
	        
	        Gson gson=new Gson();
	        JsonObject obj=new JsonObject();
	        obj.addProperty("id",id);
			obj.addProperty("nodeName", result.getNode().gettResNodeSysName());
			
			String time=result.getResultTime();
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
			
			obj.addProperty("ip", result.getNode().getIp());
			
			for(TBusinessType business: businessLists){
				String str=result.getNode().getAppSys().getAppSysType();
				if(str.equals(""+business.getId())){
					obj.addProperty("businessType", business.gettBusinessTypeName());
					break;
				}
			}
			
			String output=result.getResultOutput();
			String error=result.getResultError();
			
			JsonArray array=new JsonArray();
			if (output != null && !"".equals(output)) {
				// 分行(lines肯定不为空)
				String[] lines = output.split("\n");
				for (int i = 0; i < lines.length; i++) {
					// 对行-分割单元（cells可能为空）
					String[] cells = lines[i].split(" ");
					if (cells != null && cells.length > 0) {
						JsonObject tempObject = new JsonObject();
						// 特征字
						String chrctWord = cells[0];
						tempObject.addProperty("chrctWordValue", chrctWord);
						// 输出结果后有 \r
						String description = lines[i].substring(chrctWord.length(), lines[i].length());
						tempObject.addProperty("descriptionValue", description);
						array.add(tempObject);
					}
				}
				obj.add("ouput", array);
			}
			
			if(error!=null&&!"".equals(error)){
				obj.addProperty("error", error);
			}else{
				obj.addProperty("error", "");
			}
			
			if(output==null||"".equals(output)){
				if(error==null||"".equals(error)){
					obj.addProperty("outputOK", "OK");
				}
			}
			
	       return gson.toJson(obj);
	    }
}
