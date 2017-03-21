package com.cloudwei.dto;

import com.cloudwei.entity.Switch;
import com.cloudwei.entity.ZonePatrol;
import com.google.common.base.Function;

public class ZonePatrolDto extends BaseDto{
	public static Function<ZonePatrol, ZonePatrolDto> list=
			new Function<ZonePatrol,ZonePatrolDto>() {
		 @Override
		public ZonePatrolDto apply(ZonePatrol zonePatrol){
			ZonePatrolDto dto = new ZonePatrolDto();
			if (zonePatrol == null){
				return dto;
			}
			dto.setId(zonePatrol.getId());
			dto.setTzpActive(zonePatrol.getTzpActive());
			if(!zonePatrol.getTzpName().isEmpty()){
				
			}
			dto.setTzpName(zonePatrol.getTzpName());
			return dto;
		}
	};
	
	private int  tzpActive;
	private String  tzpName;
	private String switchElementName;
	private String ipAddress;
	private String patrolTime;
	private Switch switchPatrol;
	public int getTzpActive() {
		return tzpActive;
	}
	public void setTzpActive(int tzpActive) {
		this.tzpActive = tzpActive;
	}
	public String getTzpName() {
		return tzpName;
	}
	public void setTzpName(String tzpName) {
		this.tzpName = tzpName;
	}
	public String getSwitchElementName() {
		return switchElementName;
	}
	public void setSwitchElementName(String switchElementName) {
		this.switchElementName = switchElementName;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getPatrolTime() {
		return patrolTime;
	}
	public void setPatrolTime(String patrolTime) {
		this.patrolTime = patrolTime;
	}
	public Switch getSwitchPatrol() {
		return switchPatrol;
	}
	public void setSwitchPatrol(Switch switchPatrol) {
		this.switchPatrol = switchPatrol;
	}
	

}
