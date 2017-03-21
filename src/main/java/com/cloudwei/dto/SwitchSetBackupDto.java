package com.cloudwei.dto;

import java.util.Date;

import com.cloudwei.entity.SwitchSetBackup;
import com.google.common.base.Function;

public class SwitchSetBackupDto extends BaseDto{
	public static Function<SwitchSetBackup, SwitchSetBackupDto> list=
			new Function<SwitchSetBackup, SwitchSetBackupDto>() {

				@Override
				public SwitchSetBackupDto apply(SwitchSetBackup switchSetBackup) {
					
					SwitchSetBackupDto dto=new SwitchSetBackupDto();
					
					if(switchSetBackup==null)
						return dto;
					
					dto.setId(switchSetBackup.getId());
					dto.setSwitchSetBackupInfo(switchSetBackup.getSwitchSetBackupInfo());
					dto.setSwitchSetBackupIp(switchSetBackup.getSwitchSetBackupIp());	
					dto.setPatrolTime(switchSetBackup.getPatrolTime());
		
					return dto;
				}
					
			};
			
	
	public static Function<SwitchSetBackup, SwitchSetBackupDto> detail = 
			new Function<SwitchSetBackup, SwitchSetBackupDto>(){
		 @Override
		public SwitchSetBackupDto apply(SwitchSetBackup switchSetBackup){
			SwitchSetBackupDto dto = SwitchSetBackupDto.list.apply(switchSetBackup);
			if (switchSetBackup == null){
				return  dto;
			}
			dto.setPatrolTime(switchSetBackup.getPatrolTime());
			dto.setSwitchSetBackupOrder(switchSetBackup.getSwitchSetBackupOrder());
			
			return dto;
		}
	};
	
	
	private String switchSetBackupIp;
	private String switchSetBackupInfo;
	private int switchSetBackupOrder;
	private Date patrolTime;
	

	public Date getPatrolTime() {
		return patrolTime;
	}


	public void setPatrolTime(Date date) {
		this.patrolTime = date;
	}


	public String getSwitchSetBackupIp() {
		return switchSetBackupIp;
	}


	public void setSwitchSetBackupIp(String switchSetBackupIp) {
		this.switchSetBackupIp = switchSetBackupIp;
	}


	public String getSwitchSetBackupInfo() {
		return switchSetBackupInfo;
	}

	public void setSwitchSetBackupInfo(String switchSetBackupInfo) {
		this.switchSetBackupInfo = switchSetBackupInfo;
	}


	public int getSwitchSetBackupOrder() {
		return switchSetBackupOrder;
	}


	public void setSwitchSetBackupOrder(int switchSetBackupOrder) {
		this.switchSetBackupOrder = switchSetBackupOrder;
	}

}
