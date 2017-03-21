package com.cloudwei.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_RESULT")
public class TResult extends BaseEntity {
	
	/** 执行时间 */
	 @Column(name = "RESULT_TIME")
	private Date resultTime;

    /** 正常输出流 */
	@Column(name = "RESULT_OUTPUT")
    private String resultOutput;
    
    /** 异常输出流 */
	@Column(name = "RESULT_ERROR")
    private String resultError;
    
    /** 执行状态      <br>
     * IN PROGRESS <br>
     * FAILED      <br> 
     * SUCESSFUL   <br>
     */
	@Column(name = "HANDLE")
	private String handle;
	
	/** 处理状态 <br>
	 * OK    <br>
	 * ERROR  <br>
	 */
	@Column(name = "STATUS")
	private String status;
	
	/** 处理日志 */
	@Column(name = "REMARK")
	private String remark;
	
	@Column(name = "NODE_ID")
	private String nodeId;

	@JoinColumn(name = "JOB_ID")
	@OneToOne(fetch = FetchType.EAGER)
	private TJob Job;
	
    @JoinColumn(name="USER_ID")
    @OneToOne(fetch = FetchType.EAGER)
    private User User;

	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
	}

	public TJob getJob() {
		return Job;
	}

	public void setJob(TJob job) {
		Job = job;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public Date getResultTime() {
		return resultTime;
	}

	public void setResultTime(Date resultTime) {
		this.resultTime = resultTime;
	}

	public String getResultOutput() {
		return resultOutput;
	}

	public void setResultOutput(String resultOutput) {
		this.resultOutput = resultOutput;
	}

	public String getResultError() {
		return resultError;
	}

	public void setResultError(String resultError) {
		this.resultError = resultError;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


}
