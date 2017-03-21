package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="T_PATROL_VOLUME") 
public class TPatrolVolume extends BaseEntity
{
	private String volumeName;
	private String storagePoolName;
	private String deviceClassName;
	private String estimatedCapacity;
	private String pctUtil;
	private String volumeStatus;
	private String patrolType;
	
    @Column(name = "PATROL_TIME")
    private String patrolTime;
	
    @Column(name = "tResServer_id")
    private String serverId;

	public String getVolumeName() {
		return volumeName;
	}

	public void setVolumeName(String volumeName) {
		this.volumeName = volumeName;
	}

	public String getStoragePoolName() {
		return storagePoolName;
	}

	public void setStoragePoolName(String storagePoolName) {
		this.storagePoolName = storagePoolName;
	}

	public String getDeviceClassName() {
		return deviceClassName;
	}

	public void setDeviceClassName(String deviceClassName) {
		this.deviceClassName = deviceClassName;
	}

	public String getEstimatedCapacity() {
		return estimatedCapacity;
	}

	public void setEstimatedCapacity(String estimatedCapacity) {
		this.estimatedCapacity = estimatedCapacity;
	}

	public String getPctUtil() {
		return pctUtil;
	}

	public void setPctUtil(String pctUtil) {
		this.pctUtil = pctUtil;
	}

	public String getVolumeStatus() {
		return volumeStatus;
	}

	public void setVolumeStatus(String volumeStatus) {
		this.volumeStatus = volumeStatus;
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
