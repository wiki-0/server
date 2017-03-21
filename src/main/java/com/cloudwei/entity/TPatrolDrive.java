package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="T_PATROL_DRIVE") 
public class TPatrolDrive extends BaseEntity
{
	private String libraryName;
	private String driveName;
	private String deviceType;
	private String onLine;
	private String patrolType;
	
    @Column(name = "PATROL_TIME")
    private String patrolTime;
	
    @Column(name = "tResServer_id")
    private String serverId;

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public String getDriveName() {
		return driveName;
	}

	public void setDriveName(String driveName) {
		this.driveName = driveName;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getOnLine() {
		return onLine;
	}

	public void setOnLine(String onLine) {
		this.onLine = onLine;
	}

	public String getPatrolType() {
		return patrolType;
	}

	public void setPatrolType(String patrolType) {
		this.patrolType = patrolType;
	}

	public String getPatrolTime() {
		return patrolTime;
	}

	public void setPatrolTime(String patrolTime) {
		this.patrolTime = patrolTime;
	}

	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

}
