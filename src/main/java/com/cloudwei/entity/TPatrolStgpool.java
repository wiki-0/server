package com.cloudwei.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="T_PATROL_STGPOOL") 
public class TPatrolStgpool extends BaseEntity
{	
	private String storagePoolName;
	private String deviceClassName;
	private String estimatedCapacity;
	private String pctUtil;
	private String pctMigr;
	private String highMigPct;
	private String lowMigPct;
	private String nextStoragePool;
	private String patrolType;
	
    @Column(name = "PATROL_TIME")
    private String patrolTime;

    @Column(name = "tResServer_id")
    private String serverId;
    

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

	public String getPctMigr() {
		return pctMigr;
	}

	public void setPctMigr(String pctMigr) {
		this.pctMigr = pctMigr;
	}

	public String getHighMigPct() {
		return highMigPct;
	}

	public void setHighMigPct(String highMigPct) {
		this.highMigPct = highMigPct;
	}

	public String getLowMigPct() {
		return lowMigPct;
	}

	public void setLowMigPct(String lowMigPct) {
		this.lowMigPct = lowMigPct;
	}

	public String getNextStoragePool() {
		return nextStoragePool;
	}

	public void setNextStoragePool(String nextStoragePool) {
		this.nextStoragePool = nextStoragePool;
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
