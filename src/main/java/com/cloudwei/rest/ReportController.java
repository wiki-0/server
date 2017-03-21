package com.cloudwei.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.cloudwei.entity.BackupCliRes;
import com.cloudwei.entity.PcHardwarex86;
import com.cloudwei.entity.TJob;
import com.cloudwei.entity.TResNode;
import com.cloudwei.entity.TResult;
import com.cloudwei.entity.BackupClient;
import com.cloudwei.entity.Storage;
import com.cloudwei.entity.Switch;
import com.cloudwei.entity.User;
import com.cloudwei.repository.BackupCliResRepository;
import com.cloudwei.repository.BackupClientRepository;
import com.cloudwei.repository.PcHareWarex86Repository;
import com.cloudwei.repository.TResultRepository;
import com.cloudwei.repository.StorageRepository;
import com.cloudwei.repository.SwitchRepository;
import com.cloudwei.repository.TJobRepository;
import com.cloudwei.repository.UserRepository;
import com.cloudwei.repository.TResNodeRepository;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/report")
public class ReportController {

	private static Gson gson=new Gson();
    @Autowired
    private TResultRepository TResultRepository;
    @Autowired
    private StorageRepository StorageRepository;
    @Autowired
    private SwitchRepository SwitchRepository;
    @Autowired
    private BackupClientRepository BackupClientRepository;
    @Autowired
    private BackupCliResRepository BackupCliResRepository;
    @Autowired
    private PcHareWarex86Repository pcHareWarex86Repository;
    @Autowired
    private TJobRepository TJobRepository;
    @Autowired
    private TResNodeRepository TResNodeRepository;
    @Autowired
    private UserRepository UserRepository;
    /**
     * 巡检结果
     */
    @RequestMapping("/hispartol")  
    public String getHisPatrolResults(
    		  @RequestParam(value = "queryTime", defaultValue = "") String queryTime,
              @RequestParam(value = "typePatrol", defaultValue = "") String typePatrol,
  			  @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
  			  @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) throws ParseException {
    	JsonObject result = new JsonObject(); 
		JsonArray arr = new JsonArray();
		if(pageNum<0){
			pageNum = 0;
		}
		if(typePatrol.equals("6")){
			PageRequest pageRequest = new PageRequest(pageNum, pageSize,Direction.DESC,"patrolTime");
			Page<PcHardwarex86> fromPage = pcHareWarex86Repository.findAll(pageRequest);
			if (!StringUtils.isEmpty(queryTime)) {
				fromPage = pcHareWarex86Repository.findByPatrolTimeStartingWith(queryTime, pageRequest);
			}
			List <PcHardwarex86> tResults =fromPage.getContent();
			result.addProperty("totalElements",fromPage.getTotalElements());
			result.addProperty("totalPages",fromPage.getTotalPages());
			result.addProperty("number",fromPage.getNumber());
			result.addProperty("size",fromPage.getSize());
			result.addProperty("numberOfElements",fromPage.getNumberOfElements());
			if(tResults!=null && tResults.size()>0)
			{
				for (PcHardwarex86 tResult : tResults) {
					JsonObject obj = new JsonObject(); 
					obj.addProperty("jobName", tResult.getPcHardWareIp());
					obj.addProperty("resultError", "");
					obj.addProperty("resultOutput", tResult.getPcHardWareContent());
					obj.addProperty("resultTime",tResult.getPatrolTime());
					arr.add(obj);
				}
			}
		}else{
			PageRequest pageRequest = new PageRequest(pageNum, pageSize,Direction.DESC,"resultTime");
			Page<TResult> tR;
			if (!StringUtils.isEmpty(queryTime)) {
					SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    		Date queryDate = matter1.parse(queryTime+" 00:00:00");
		    		Date endDate = matter1.parse(queryTime+" 23:59:59");
		    		tR = TResultRepository.getJobType(queryDate ,endDate , typePatrol ,pageRequest);
	        }else{
	        	tR = TResultRepository.findAll(pageRequest);
	        }
			List <TResult> tResults =tR.getContent();
			result.addProperty("totalElements",tR.getTotalElements());
			result.addProperty("totalPages",tR.getTotalPages());
			result.addProperty("number",tR.getNumber());
			result.addProperty("size",tR.getSize());
			result.addProperty("numberOfElements",tR.getNumberOfElements());
			if(tResults!=null && tResults.size()>0)
			{
				for (TResult tResult : tResults) {
					JsonObject obj = new JsonObject(); 
					obj.addProperty("jobName", tResult.getJob().getName());
					obj.addProperty("resultError", tResult.getResultError());
					if(tResult.getResultOutput()!=null && !"".equals(tResult.getResultOutput()))
					{
						obj.addProperty("resultOutput",(tResult.getResultOutput().length()>80 ? tResult.getResultOutput().substring(0,80)+" ..." : tResult.getResultOutput() ));
					}
					else {
						obj.addProperty("resultOutput","");
					}
					if(tResult.getResultError()!=null && !"".equals(tResult.getResultError()))
					{
						if(tResult.getResultError().length()>80)
						{
							obj.addProperty("resultError",(tResult.getResultError().length()>80 ? tResult.getResultError().substring(0,80)+" ..." : tResult.getResultError() ));
						}
						else {
							obj.addProperty("resultError", tResult.getResultError() );
						}
						
					}
					else {
						obj.addProperty("resultError","");
					}
					if(tResult.getResultOutput()==null || "".equals(tResult.getResultOutput()))
					{
						if(tResult.getResultError() ==null || "".equals(tResult.getResultError()) )
						{
							obj.addProperty("resultOutput", "正常");
						}
					}
					if(tResult.getResultTime()!=null)
					{
						obj.addProperty("resultTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(tResult.getResultTime()));
					}
					else
					{
						obj.addProperty("resultTime","--");
					}
//					obj.addProperty("status", tResult.getStatus());
					arr.add(obj);
				}
			}
		}
		result.add("items",arr);
		return gson.toJson(result);
    }
    /**
     * 调度报表 调度统计
     * @throws ParseException 
     */
    @RequestMapping("/host")  
    public String getTJob(
            @RequestParam(value = "startDate", defaultValue = "") String startDate,
            @RequestParam(value = "endDate", defaultValue = "") String endDate,
    		@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) throws ParseException {
    	SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start = matter1.parse(startDate+" 00:00:00");
		Date end = matter1.parse(endDate+" 23:59:59");
    	JsonObject result=new JsonObject();
    	if(pageNum<0){
			pageNum = 0;
		}
    	PageRequest pageRequest = new PageRequest(pageNum, pageSize,Direction.ASC,"name");
		Page<TJob> tR = TJobRepository.findAll(pageRequest);
		List <TJob> tJobs =tR.getContent();
		result.addProperty("totalElements",tR.getTotalElements());
		result.addProperty("totalPages",tR.getTotalPages());
		result.addProperty("number",tR.getNumber());
		result.addProperty("size",tR.getSize());
		result.addProperty("numberOfElements",tR.getNumberOfElements());
		JsonArray arr = new JsonArray();
		 for(TJob tJob:tJobs){
	    	List<TResult> tOkRes = TResultRepository.getStatus(start, end,"OK",tJob.getId());
	    	List<TResult> tErrorRes = TResultRepository.getStatus(start, end,"ERROR",tJob.getId());
	    	JsonObject obj=new JsonObject();
	    	obj.addProperty("jobId", tJob.getId());
	    	obj.addProperty("jobName", tJob.getName());
	    	obj.addProperty("errorNum", tErrorRes.size());
	    	obj.addProperty("okNum", tOkRes.size());
			arr.add(obj);
	    }
		 result.add("items",arr);
		return gson.toJson(result);
    }
    /**
     * 调度报表 charts
     */
    @RequestMapping("/hostcharts")
    public  String getTResultByJob(
            @RequestParam(value = "startDate", defaultValue = "") String startDate,
            @RequestParam(value = "endDate", defaultValue = "") String endDate,
            @RequestParam(value = "jodId", defaultValue = "") String jodId) throws ParseException {
    	SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	SimpleDateFormat matter2 = new SimpleDateFormat("yyyy-MM-dd");
		Date start = matter1.parse(startDate+" 00:00:00");
		Date end = matter1.parse(endDate+" 23:59:59");
        String dataY="[";
		String dataX="[";
        JsonObject result=new JsonObject();
        Calendar start1 = Calendar.getInstance();
		start1.setTime(start);
		Long startTIme = start1.getTimeInMillis();
		Calendar end1 = Calendar.getInstance();
		end1.setTime(end);
		Long endTime = end1.getTimeInMillis();
		Long oneDay = 1000 * 60 * 60 * 24l;
		Long time = startTIme;
		while (time <= endTime) {
			Date d = new Date(time);
			time += oneDay;
			Date d2 = new Date(time);
			List<TResult> tResults = TResultRepository.getJobId("ERROR", d, d2 ,Long.valueOf(jodId));
			dataY += tResults.size() + ",";
			dataX += "\'" + matter2.format(d) + "\',";
		}
		dataY = dataY.substring(0, dataY.length() - 1) + "]";
		dataX = dataX.substring(0, dataX.length() - 1) + "]";
		result.addProperty("status", "1");
		result.addProperty("xcharts", dataX);
		result.addProperty("ycharts", dataY);
        return gson.toJson(result);
    }
    /**
     * 节点报表 charts
     */
    @RequestMapping("/host2")
    public  String getTResultbyNode(
            @RequestParam(value = "startDate", defaultValue = "") String startDate,
            @RequestParam(value = "endDate", defaultValue = "") String endDate,
            @RequestParam(value = "nodeId", defaultValue = "") String nodeId) throws ParseException {
    	SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	SimpleDateFormat matter2 = new SimpleDateFormat("yyyy-MM-dd");
		Date start = matter1.parse(startDate+" 00:00:00");
		Date end = matter1.parse(endDate+" 23:59:59");
        String dataY="[";
		String dataX="[";
        JsonObject result=new JsonObject();
		Calendar start1 = Calendar.getInstance();
		start1.setTime(start);
		Long startTIme = start1.getTimeInMillis();
		Calendar end1 = Calendar.getInstance();
		end1.setTime(end);
		Long endTime = end1.getTimeInMillis();
		Long oneDay = 1000 * 60 * 60 * 24l;
		Long time = startTIme;
		while (time <= endTime) {
			Date d = new Date(time);
			time += oneDay;
			Date d2 = new Date(time);
			List<TResult> tResults = TResultRepository.findByNodeIdAndStatusAndResultTimeBetween(nodeId,"ERROR", d, d2);
			dataY += tResults.size() + ",";
			dataX += "\'" + matter2.format(d) + "\',";
		}
		dataY = dataY.substring(0, dataY.length() - 1) + "]";
		dataX = dataX.substring(0, dataX.length() - 1) + "]";
		result.addProperty("status", "1");
		result.addProperty("xcharts", dataX);
		result.addProperty("ycharts", dataY);
		return gson.toJson(result);
    }
    /**
     * 节点报表 详细数据
     * @throws ParseException 
     */
    @RequestMapping("/hostdetail")  
    public String getHostDeatil(
    		@RequestParam(value = "startDate", defaultValue = "") String startDate,
            @RequestParam(value = "endDate", defaultValue = "") String endDate,
    		@RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) throws ParseException {
    	SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	JsonObject result=new JsonObject();
    	if(pageNum<0){
			pageNum = 0;
		}
    	PageRequest pageRequest = new PageRequest(pageNum, pageSize,Direction.ASC,"id");
		Page<TJob> tR = TJobRepository.findAll(pageRequest);
		List <TJob> tJobs =tR.getContent();
		result.addProperty("totalElements",tR.getTotalElements());
		result.addProperty("totalPages",tR.getTotalPages());
		result.addProperty("number",tR.getNumber());
		result.addProperty("size",tR.getSize());
		result.addProperty("numberOfElements",tR.getNumberOfElements());
		JsonArray arr = new JsonArray();
		if(!StringUtils.isEmpty(startDate)&&!StringUtils.isEmpty(endDate)){
			Date start = matter1.parse(startDate+" 00:00:00");
			Date end = matter1.parse(endDate+" 23:59:59");
			 for(TJob tJob:tJobs){
		    	List<TResult> tOkRes = TResultRepository.getStatus(start, end,"OK",tJob.getId());
		    	List<TResult> tErrorRes = TResultRepository.getStatus(start, end,"ERROR",tJob.getId());
		    	JsonObject obj=new JsonObject();
		    	obj.addProperty("jobName", tJob.getName());
		    	obj.addProperty("remark", tOkRes.size()+"/"+tErrorRes.size());
				arr.add(obj);
		    }
		}else{
			for(TJob tJob:tJobs){
		    	List<TResult> tOkRes = TResultRepository.getAllStatus("OK",tJob.getId());
		    	List<TResult> tErrorRes = TResultRepository.getAllStatus("ERROR",tJob.getId());
		    	JsonObject obj=new JsonObject();
		    	obj.addProperty("jobName", tJob.getName());
		    	obj.addProperty("remark", tOkRes.size()+"/"+tErrorRes.size());
				arr.add(obj);
		    }
		}
		result.add("items",arr);
		return gson.toJson(result);
    }
    /**
     * 存储巡检 charts
     */
    @RequestMapping("/storagecharts")
    public  String geStorageReport(
    		@RequestParam(value = "elementName", defaultValue = "") String elementName,
            @RequestParam(value = "startDate", defaultValue = "") String startDate,
            @RequestParam(value = "endDate", defaultValue = "") String endDate) throws ParseException {
    	SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	SimpleDateFormat matter2 = new SimpleDateFormat("yyyy-MM-dd");
		Date start = matter1.parse(startDate+" 00:00:00");
		Date end = matter1.parse(endDate+" 23:59:59");
        String dataY="[";
		String dataX="[";
        JsonObject result=new JsonObject();
        Calendar start1 = Calendar.getInstance();
		start1.setTime(start);
		Long startTIme = start1.getTimeInMillis();
		Calendar end1 = Calendar.getInstance();
		end1.setTime(end);
		Long endTime = end1.getTimeInMillis();
		Long oneDay = 1000 * 60 * 60 * 24l;
		Long time = startTIme;
		while (time <= endTime) {
			Date d = new Date(time);
			time += oneDay;
			Date d2 = new Date(time);
			List<Storage> storages = StorageRepository.findByElementNameAndPatrolTimeBetween(elementName, d, d2);
			int s = 0 ;
			for(Storage storage :storages){
				if(storage.getAllStatus().equals("错误")){
					s+=1;
				}
			}
			dataY += s + ",";
			dataX += "\'" + matter2.format(d) + "\',";
		}
		dataY = dataY.substring(0, dataY.length() - 1) + "]";
		dataX = dataX.substring(0, dataX.length() - 1) + "]";
		result.addProperty("status", "1");
		result.addProperty("xcharts", dataX);
		result.addProperty("ycharts", dataY);
        return gson.toJson(result);
    }
    /**
     * 光交巡检 charts
     */
    @RequestMapping("/switchcharts")
    public  String getSwitchReport(
            @RequestParam(value = "startDate", defaultValue = "") String startDate,
            @RequestParam(value = "endDate", defaultValue = "") String endDate,
            @RequestParam(value = "elementName", defaultValue = "") String elementName) throws ParseException {
    	SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	SimpleDateFormat matter2 = new SimpleDateFormat("yyyy-MM-dd");
		Date start = matter1.parse(startDate+" 00:00:00");
		Date end = matter1.parse(endDate+" 23:59:59");
        String dataY="[";
		String dataX="[";
        JsonObject result=new JsonObject();
        Calendar start1 = Calendar.getInstance();
		start1.setTime(start);
		Long startTIme = start1.getTimeInMillis();
		Calendar end1 = Calendar.getInstance();
		end1.setTime(end);
		Long endTime = end1.getTimeInMillis();
		Long oneDay = 1000 * 60 * 60 * 24l;
		Long time = startTIme;
		while (time <= endTime) {
			Date d = new Date(time);
			time += oneDay;
			Date d2 = new Date(time);
			List<Switch> switchs = SwitchRepository.findByElementNameAndPatrolTimeBetween(elementName, d, d2);
			int s = 0 ;
			for(Switch sw :switchs){
				if(sw.getAllStatus().equals("错误")){
					s+=1;
				}
			}
			dataY += s + ",";
			dataX += "\'" + matter2.format(d) + "\',";
		}
		dataY = dataY.substring(0, dataY.length() - 1) + "]";
		dataX = dataX.substring(0, dataX.length() - 1) + "]";
		result.addProperty("status", "1");
		result.addProperty("xcharts", dataX);
		result.addProperty("ycharts", dataY);
        return gson.toJson(result);
    }
    /**
     * 备份巡检
     */
    @RequestMapping("/tsmbm")
    public  String getTsmBm(
            @RequestParam(value = "startDate", defaultValue = "") String startDate,
            @RequestParam(value = "endDate", defaultValue = "") String endDate,
            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) throws ParseException {
    	SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start = matter1.parse(startDate+" 00:00:00");
		Date end = matter1.parse(endDate+" 23:59:59");
		JsonObject result=new JsonObject();
		if(pageNum<0){
			pageNum = 0;
		}
		PageRequest pageRequest = new PageRequest(pageNum, pageSize,Direction.DESC,"id");
		Page<BackupClient> tR = BackupClientRepository.getAll(pageRequest);
		List <BackupClient> backupClientList =tR.getContent();
		result.addProperty("totalElements",tR.getTotalElements());
		result.addProperty("totalPages",tR.getTotalPages());
		result.addProperty("number",tR.getNumber());
		result.addProperty("size",tR.getSize());
		result.addProperty("numberOfElements",tR.getNumberOfElements());
		HashMap<String,String> clientMap = new HashMap<String,String>();
		if(backupClientList!=null && backupClientList.size()>0)
		{
			for(BackupClient backupClient: backupClientList)
			{
				if(backupClient!=null)
				{
					clientMap.put(backupClient.getIp(), backupClient.getIp());
				}
			}
		}
		if(clientMap!=null && clientMap.size()>0)
		{
			JsonArray arr = new JsonArray();
			String[] ips=clientMap.values().toArray(new String[0]);
			for(String ip: ips)
			{
				JsonObject obj = new JsonObject();  
				if(ip!=null && !"".equals(ip))
				{
					int okNum = 0;
					int errorNum = 0;
					obj.addProperty("ip",ip);
					List<BackupCliRes> list = BackupCliResRepository.findByIpAndPatrolTimeBetween(ip, start, end);
					int sum = list.size();
					obj.addProperty("sum",sum);
					for(BackupCliRes backupCliRes : list)
					{
						if(backupCliRes!=null)
						{
							if(backupCliRes.getBmResult().equals("OK"))
							{
								okNum++;
							}
							else if(backupCliRes.getBmResult().equals("ERROR") )
							{
								errorNum++;
							}
						}
					}
					obj.addProperty("errorNum",errorNum);
					obj.addProperty("okNum",okNum);
				}
				  arr.add(obj);
			}
			result.add("items",arr);
		}
		 return gson.toJson(result);
    }
    /**
     * 备份巡检 详细
     */
    @RequestMapping(value="/tsmbmip")
    public String getTsmBmIp(
    		@RequestParam(value = "ip", defaultValue = "") String ip,
    		@RequestParam(value = "startDate", defaultValue = "") String startDate,
            @RequestParam(value = "endDate", defaultValue = "") String endDate,
            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) throws ParseException {
    	JsonObject result = new JsonObject(); 
    	JsonArray arr = new JsonArray();
    	SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start = matter1.parse(startDate+" 00:00:00");
		Date end = matter1.parse(endDate+" 23:59:59");
		PageRequest pageRequest = new PageRequest(pageNum, pageSize,Direction.DESC,"id");
		if(pageNum<0){
			pageNum = 0;
		}
		Page<BackupCliRes> tR = BackupCliResRepository.findByIpAndBmResultAndPatrolTimeBetween(ip, "ERROR",start, end,pageRequest);
		List <BackupCliRes> list =tR.getContent();
		result.addProperty("totalElements",tR.getTotalElements());
		result.addProperty("totalPages",tR.getTotalPages());
		result.addProperty("number",tR.getNumber());
		result.addProperty("size",tR.getSize());
		result.addProperty("numberOfElements",tR.getNumberOfElements());
		for(BackupCliRes backupCliRes : list)
		{
			if(backupCliRes!=null)
			{
				JsonObject obj = new JsonObject(); 
				obj.addProperty("ip",ip);
				obj.addProperty("location",backupCliRes.getLocation());
				obj.addProperty("fileDate",backupCliRes.getFileDate());
				obj.addProperty("ip",ip);
				SimpleDateFormat matter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String date=matter2.format(backupCliRes.getPatrolTime());  
				obj.addProperty("reDate",date);
				obj.addProperty("patroltype",backupCliRes.getPatrolType());
				obj.addProperty("bmResult",backupCliRes.getBmResult());
				arr.add(obj);
			}
		}
		result.add("items",arr);
        return gson.toJson(result);
    }
    /**
     * 绩效管理
     */
    @RequestMapping("/achievements")  
    public String getAchievements() { 
    	JsonObject result=new JsonObject();
		List <User> users =UserRepository.findAll();
		JsonArray arr = new JsonArray();
		 for(User user:users){
	    	JsonObject obj=new JsonObject();
	    	List<TResult> tResults = TResultRepository.findByUserId(user.getId());
	    	int succ = 0;
	    	int fail = 0;
	    	int remark = 0;
			for (TResult tResult : tResults) {
				if (tResult.getHandle() == "SUCESSFUL") {
					succ++;
				}
				if (tResult.getHandle() == "FAIL") {
					fail++;
				}
				if (tResult.getRemark() != "") {
					remark++;
				}
			}
			obj.addProperty("username", user.getUserName());
			obj.addProperty("all", succ+fail+remark);
			obj.addProperty("succ", succ);
			obj.addProperty("fail", fail);
			obj.addProperty("remark", remark);
			 arr.add(obj);
	    }
		result.add("items",arr);
		return gson.toJson(result);
    }
    /**
     * 告警通知详情
     */
    @RequestMapping(value="/pushmsg")
    public String getPushmsg(
    		@RequestParam(value = "sid", defaultValue = "") String sid,
    		@RequestParam(value = "stype", defaultValue = "") String stype,
            @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) throws ParseException {
    	JsonObject result = new JsonObject();
		if(pageNum<0){
			pageNum = 0;
		}
		if(stype.equals("1")){
			//1.巡检执行失败
			TResult tResult = TResultRepository.findById(Long.valueOf(sid));
			if(tResult.getResultError()!=null && !"".equals(tResult.getResultError()))
			{
				if(tResult.getResultError().length()>50)
				{
					result.addProperty("error",(tResult.getResultError().length()>50 ? tResult.getResultError().substring(0,50)+"..." : tResult.getResultError()));
				}
				else {
					result.addProperty("error",tResult.getResultError());
				}
			}
			if(tResult.getResultTime()!=null)
			{
				result.addProperty("time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(tResult.getResultTime()));
			}
			result.addProperty("jobname",tResult.getJob().getName());
			TResNode node = TResNodeRepository.findById(Long.valueOf(tResult.getNodeId()));
			result.addProperty("room",node.getRoomPosition());
			result.addProperty("ip",node.getIp());
		}
    	return gson.toJson(result);
    }
}
