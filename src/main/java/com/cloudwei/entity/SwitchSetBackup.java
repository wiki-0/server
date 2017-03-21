package com.cloudwei.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name="T_SWITH_SETBACKUP")
public class SwitchSetBackup extends BaseEntity{
	@Column(name="T_SWITH_SETBACKUP_IP")
	private String switchSetBackupIp;
	
	@Column(name="T_SWITH_SETBACKUP_INFO")
	private String switchSetBackupInfo;
	
	@Column(name="T_SWITH_SETBACKUP_ORDER")
	private int switchSetBackupOrder;
	
	private Date patrolTime;

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

	public Date getPatrolTime() {
		return patrolTime;
	}

	public void setPatrolTime(Date patrolTime) {
		this.patrolTime = patrolTime;
	}
}