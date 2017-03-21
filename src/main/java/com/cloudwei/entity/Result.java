package com.cloudwei.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="T_RESULT")
public class Result extends BaseEntity{
	
	@Column(name="HANDLE")
	private String handle;
	@Column(name = "REMARK")
	@Lob
	private String remark;
	@Column(name="RESULT_ERROR")
	@Lob
	private String resultError;
	@Column(name="RESULT_OUTPUT")
	@Lob
	private String resultOutput;
	@Column(name="RESULT_TIME")
	private String resultTime;
	@Column(name="STATUS")
	private String status;

	@JoinColumn(name="JOB_ID")
	@OneToOne
	private TJob job;
	
	@JoinColumn(name="NODE_ID")
	@OneToOne
	private TNode node;
	
	@JoinColumn(name="USER_ID")
	@OneToOne
	private User user;

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	

	public String getResultError() {
		return resultError;
	}

	public void setResultError(String resultError) {
		this.resultError = resultError;
	}

	public String getResultOutput() {
		return resultOutput;
	}

	public void setResultOutput(String resultOutput) {
		this.resultOutput = resultOutput;
	}

	public String getResultTime() {
		return resultTime;
	}

	public void setResultTime(String resultTime) {
		this.resultTime = resultTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TJob getJob() {
		return job;
	}

	public void setJob(TJob job) {
		this.job = job;
	}

	public TNode getNode() {
		return node;
	}

	public void setNode(TNode node) {
		this.node = node;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
