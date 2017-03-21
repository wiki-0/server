package com.cloudwei.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "T_JOB")
public class TJob extends BaseEntity {

	@Column(name = "CHECKS")
	private String checks;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PATH")
	private String path;
	@Column(name = "REMARK")
	private String remark;
	@Column(name = "SCHEDULES")
	private String schedules;
	@Column(name = "SHELLS")
	@Lob
	private String shells;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "EXEC_TYPE")
	private String execType;
	@Column(name = "LOGIN_TYPE")
	private String loginType;
	@Column(name = "UPLOAD_TYPE")
	private String uploadType;

	@ManyToMany(targetEntity = TNode.class, fetch = FetchType.EAGER)
	@JoinTable(name = "T_RES_JOB2NODE", inverseJoinColumns = @JoinColumn(name = "NODE_ID"))
	public Set<TNode> nodes = new HashSet<TNode>();

	public String getChecks() {
		return checks;
	}

	public void setChecks(String checks) {
		this.checks = checks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSchedules() {
		return schedules;
	}

	public void setSchedules(String schedules) {
		this.schedules = schedules;
	}

	public String getShells() {
		return shells;
	}

	public void setShells(String shells) {
		this.shells = shells;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExecType() {
		return execType;
	}

	public void setExecType(String execType) {
		this.execType = execType;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getUploadType() {
		return uploadType;
	}

	public void setUploadType(String uploadType) {
		this.uploadType = uploadType;
	}

	public Set<TNode> getNodes() {
		return nodes;
	}

	public void setNodes(Set<TNode> nodes) {
		this.nodes = nodes;
	}
	

}
