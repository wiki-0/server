package com.cloudwei.entity;

//import java.util.Date;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_Backup_CliRes")
public class BackupCliRes extends BaseEntity{
	
	private String ip;
	private String location;
	private Date patrolTime;
	private String reDate;
	private String fileDate;
	private String patrolType;
	private String bmResult;
	private long client_id;
	
	
	public String getReDate() {
		return reDate;
	}
	public void setReDate(String reDate) {
		this.reDate = reDate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Date getPatrolTime() {
		return patrolTime;
	}
	public void setPatrolTime(Date patrolTime) {
		this.patrolTime = patrolTime;
	}
	public void setPatrolType(String patrolType) {
		this.patrolType = patrolType;
	}
	public String getFileDate() {
		return fileDate;
	}
	public void setFileDate(String fileDate) {
		this.fileDate = fileDate;
	}
	public String getPatrolType() {
		return patrolType;
	}
	public void setPatroltype(String patroltype) {
		this.patrolType = patroltype;
	}
	public String getBmResult() {
		return bmResult;
	}
	public void setBmResult(String bmResult) {
		this.bmResult = bmResult;
	}
	public long getClient_id() {
		return client_id;
	}
	public void setClient_id(long client_id) {
		this.client_id = client_id;
	}
	
	
}
