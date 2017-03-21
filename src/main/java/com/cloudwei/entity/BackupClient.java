package com.cloudwei.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="T_Backup_Client") 
public class BackupClient extends BaseEntity{
	
	private String ip;
	private String userName;
	private String passwd;
	private String location;
	private String fileSuffix;
	private String type;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getFileSuffix() {
		return fileSuffix;
	}
	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}	
		

}
