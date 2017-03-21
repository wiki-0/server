package com.cloudwei.dto;

import com.cloudwei.entity.THaGpfsResults;
import com.cloudwei.entity.THaGpfsSet;
import com.cloudwei.entity.TPatrolKpiTask;
import com.cloudwei.repository.HaGpfsSetRepository;
import com.cloudwei.repository.TPatrolKpiTaskRepository;
import com.cloudwei.utils.SpringUtils;
import com.google.common.base.Function;

public class KpiTaskAixDto extends BaseDto{
	
	 public static Function<THaGpfsResults, KpiTaskAixDto> list =
	            new Function<THaGpfsResults, KpiTaskAixDto>() {
		 
		 @Override
         public KpiTaskAixDto apply(THaGpfsResults input) {
			 
			 KpiTaskAixDto dto=new KpiTaskAixDto();
			 if (input==null) {
				 return dto;
			}
			
			 TPatrolKpiTaskRepository kpiTask=SpringUtils.getBean(TPatrolKpiTaskRepository.class);
			 HaGpfsSetRepository haGpfsSetRepository=SpringUtils.getBean(HaGpfsSetRepository.class);
			 
			 TPatrolKpiTask tPatrolKpiTask=kpiTask.findOne(input.gettHaGpfsResultsTaskId());
			 THaGpfsSet tHaGpfsSet=haGpfsSetRepository.findOne(input.gettHagpfsResultsSetId());
			 
			 tHaGpfsSet.settHaGpfsSetShow("无");
			 String result_status=input.gettHaGpfsResultsShowvalue();
			 
			 if(result_status.equalsIgnoreCase("OK")){
				 if(input.gettHaGpfsResultsResult().contains("error")){
					 tHaGpfsSet.settHaGpfsSetShow("异常 : "+input.gettHaGpfsResultsResult());
				 }
				 else 
					 tHaGpfsSet.settHaGpfsSetShow(input.gettHaGpfsResultsResult());
			 }
			 else if(result_status.equalsIgnoreCase("ERROR")){
				 tHaGpfsSet.settHaGpfsSetShow("异常 : "+input.gettHaGpfsResultsResult());
			 }
				
			
			 	dto.setId(input.getId());
				dto.setIp(tPatrolKpiTask.gettPatrolKpiTaskIp());
				dto.setPatrolTime(tPatrolKpiTask.getPatrolTime());
				
				dto.setStatus(input.gettHaGpfsResultsShowvalue());
				dto.setTaskID(input.gettHaGpfsResultsTaskId());
				
				dto.setSetName(tHaGpfsSet.getTHaGpfsSet_NAME());
				dto.setSetShow(tHaGpfsSet.gettHaGpfsSetShow());
			 return dto;
		 }
	 };
	 
	 
	 public static Function<THaGpfsResults, KpiTaskAixDto> detail=
				new  Function<THaGpfsResults, KpiTaskAixDto>(){
			
			@Override
			public KpiTaskAixDto apply(THaGpfsResults tHaGpfsResults){
				
				KpiTaskAixDto dto=KpiTaskAixDto.list.apply(tHaGpfsResults);
				if(tHaGpfsResults==null)
					return dto;
				
				return dto;
				
			}
		};
	 /**
		 * Task
		 */
		private String ip;
		private String taskSysname;
		private String patrolTime;
		
		/**
		 * Set
		 */
		private String setName;
		private String setShow;
		
		/**
		 * Result
		 */
		private String status;
		private long taskID;
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getIp() {
			return ip;
		}
		public void setIp(String ip) {
			this.ip = ip;
		}
		public String getTaskSysname() {
			return taskSysname;
		}
		public void setTaskSysname(String taskSysname) {
			this.taskSysname = taskSysname;
		}
		public String getPatrolTime() {
			return patrolTime;
		}
		public void setPatrolTime(String patrolTime) {
			this.patrolTime = patrolTime;
		}
		public String getSetName() {
			return setName;
		}
		public void setSetName(String setName) {
			this.setName = setName;
		}
		public String getSetShow() {
			return setShow;
		}
		public void setSetShow(String setShow) {
			this.setShow = setShow;
		}
		
		public long getTaskID() {
			return taskID;
		}
		public void setTaskID(long taskID) {
			this.taskID = taskID;
		}
	 
}
