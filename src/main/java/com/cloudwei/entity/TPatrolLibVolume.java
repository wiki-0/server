package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="T_PATROL_LIBVOLUME") 
public class TPatrolLibVolume extends BaseEntity
{
	private String libraryName;
	private String volumeName;
	private String status;
	private String owner;
	private String lastUse;
	private String homeElement;
	private String deviceType;
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

	public String getVolumeName() {
		return volumeName;
	}

	public void setVolumeName(String volumeName) {
		this.volumeName = volumeName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getLastUse() {
		return lastUse;
	}

	public void setLastUse(String lastUse) {
		this.lastUse = lastUse;
	}

	public String getHomeElement() {
		return homeElement;
	}

	public void setHomeElement(String homeElement) {
		this.homeElement = homeElement;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
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
