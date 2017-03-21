package com.cloudwei.dto;


import com.cloudwei.entity.THaGpfsTask;
import com.google.common.base.Function;

public class HaGpfsTaskDto extends BaseDto {
	
	public static Function<THaGpfsTask, HaGpfsTaskDto> list=
		new Function<THaGpfsTask, HaGpfsTaskDto>(){
		
		@Override
		public HaGpfsTaskDto apply(THaGpfsTask tHaGpfsTask){
			HaGpfsTaskDto dto=new HaGpfsTaskDto();
			if(tHaGpfsTask==null)
				return dto;
			dto.setId(tHaGpfsTask.getId());
			dto.settHaGpfsTaskIp(tHaGpfsTask.gettHaGpfsTaskIp());
			dto.settHaGpfsTaskSysname(	tHaGpfsTask.gettHaGpfsTaskSysname());
			dto.setPatrolTime(tHaGpfsTask.getPatrolTime());
			
			return dto;
		}
	};
	
	
	private String  tHaGpfsTaskIp;
	private String tHaGpfsTaskSysname;
	private String patrolTime;
	
	public String gettHaGpfsTaskIp() {
		return tHaGpfsTaskIp;
	}
	public void settHaGpfsTaskIp(String tHaGpfsTaskIp) {
		this.tHaGpfsTaskIp = tHaGpfsTaskIp;
	}
	public String gettHaGpfsTaskSysname() {
		return tHaGpfsTaskSysname;
	}
	public void settHaGpfsTaskSysname(String tHaGpfsTaskSysname) {
		this.tHaGpfsTaskSysname = tHaGpfsTaskSysname;
	}
	public String getPatrolTime() {
		return patrolTime;
	}
	public void setPatrolTime(String patrolTime) {
		this.patrolTime = patrolTime;
	}
}
