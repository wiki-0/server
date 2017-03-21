package com.cloudwei.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="T_Ha_Gpfs_Task") 
public class THaGpfsTask extends BaseEntity{
	@Column(name="THaGpfsTask_IP")
	private String tHaGpfsTaskIp;
	
	@Column(name="THaGpfsTask_SYSNAME")
	private String tHaGpfsTaskSysname;
	
	@Column(name="patroltype")
	private String patrolType;
	
	 /** 主备顺序      <br>
     * 1为主      <br>
     * 2为备      <br> 
     */
	@Column(name="THaGpfsTask_ORDER")
	private String tHaGpfsTaskOrder;
	
	private String patrolTime;

	public String gettHaGpfsTaskIp() {
		return tHaGpfsTaskIp;
	}

	public void settHaGpfsTaskIp(String tHaGpfsTaskIp) {
		this.tHaGpfsTaskIp = tHaGpfsTaskIp;
	}

	public String gettHaGpfsTaskSysname() {
		return tHaGpfsTaskSysname;
	}

	public void settHaGpfsTaskSysname(String tHaGpfsTaskSysname) {
		this.tHaGpfsTaskSysname = tHaGpfsTaskSysname;
	}

	public String getPatrolType() {
		return patrolType;
	}

	public void setPatrolType(String patrolType) {
		this.patrolType = patrolType;
	}

	public String gettHaGpfsTaskOrder() {
		return tHaGpfsTaskOrder;
	}

	public void settHaGpfsTaskOrder(String tHaGpfsTaskOrder) {
		this.tHaGpfsTaskOrder = tHaGpfsTaskOrder;
	}

	public String getPatrolTime() {
		return patrolTime;
	}

	public void setPatrolTime(String  patrolTime) {
		this.patrolTime = patrolTime;
	}

	
}
