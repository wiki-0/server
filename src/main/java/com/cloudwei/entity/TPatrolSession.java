package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="T_PATROL_SESSION") 
public class TPatrolSession extends BaseEntity
{
	
	private String sessNumber;
	private String commMethod;
	private String sessState;
	private String waitTime;
	private String bytesSent;
	private String bytesRecvd;
	private String sessType;
	private String platform;
	private String clientName;
	private String patrolType;
	
    @Column(name = "PATROL_TIME")
    private String patrolTime;
	
    @Column(name = "tResServer_id")
    private String serverId;

	public String getSessNumber() {
		return sessNumber;
	}

	public void setSessNumber(String sessNumber) {
		this.sessNumber = sessNumber;
	}

	public String getCommMethod() {
		return commMethod;
	}

	public void setCommMethod(String commMethod) {
		this.commMethod = commMethod;
	}

	public String getSessState() {
		return sessState;
	}

	public void setSessState(String sessState) {
		this.sessState = sessState;
	}

	public String getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(String waitTime) {
		this.waitTime = waitTime;
	}

	public String getBytesSent() {
		return bytesSent;
	}

	public void setBytesSent(String bytesSent) {
		this.bytesSent = bytesSent;
	}

	public String getBytesRecvd() {
		return bytesRecvd;
	}

	public void setBytesRecvd(String bytesRecvd) {
		this.bytesRecvd = bytesRecvd;
	}

	public String getSessType() {
		return sessType;
	}

	public void setSessType(String sessType) {
		this.sessType = sessType;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
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
