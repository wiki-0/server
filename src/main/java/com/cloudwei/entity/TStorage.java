package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_STORAGE")

public class TStorage extends BaseEntity {

	@Column(name = "MODEL")
	private String model;

	@Column(name = "VENDOR")
	private String vendor;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "ALLSTATUS")
	private String allStatus;

	@Column(name = "ELEMENT_NAME")
	private String elementName;

	@Column(name = "PATROLTIME")
	private String patrolTime;

	@Column(name = "CODE_LEVEL")
	private String codeLevel;

	@Column(name = "TDISKS")
	private String tdisks;

	@Column(name = "VOLUMES")
	private String volumes;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAllStatus() {
		return allStatus;
	}

	public void setAllStatus(String allStatus) {
		this.allStatus = allStatus;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public String getPatrolTime() {
		return patrolTime;
	}

	public void setPatrolTime(String patrolTime) {
		this.patrolTime = patrolTime;
	}

	public String getCodeLevel() {
		return codeLevel;
	}

	public void setCodeLevel(String codeLevel) {
		this.codeLevel = codeLevel;
	}

	public String getTdisks() {
		return tdisks;
	}

	public void setTdisks(String tdisks) {
		this.tdisks = tdisks;
	}

	public String getVolumes() {
		return volumes;
	}

	public void setVolumes(String volumes) {
		this.volumes = volumes;
	}

}
