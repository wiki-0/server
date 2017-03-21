package com.cloudwei.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="T_PHTH_REASON")
public class TPhThReason  extends BaseEntity{
	
	private String phthId;


	private String content;
	private String ip;
	
	private String resultId;
	
	private Date patrolTime = new Date();

	public String getPhthId() {
		return phthId;
	}

	public void setPhthId(String phthId) {
		this.phthId = phthId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getResultId() {
		return resultId;
	}

	public void setResultId(String resultId) {
		this.resultId = resultId;
	}

	public Date getPatrolTime() {
		return patrolTime;
	}

	public void setPatrolTime(Date patrolTime) {
		this.patrolTime = patrolTime;
	}
	
	
	
}

