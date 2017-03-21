package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_RES_LUN_MAPPING")

public class TResLunMapping extends BaseEntity {

	@Column(name = "HOST_NAME")
	private String hostName;

	@Column(name = "FCPORT")
	private String fcport;

	@Column(name = "HBA_WWN")
	private String hbaWwn;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "VOLUME")
	private String volume;

	@JoinColumn(name = "STORAGE_ID")
	@ManyToOne
	private TStorage storageID;

	public TStorage getStorageID() {
		return storageID;
	}

	public void setStorageID(TStorage storageID) {
		this.storageID = storageID;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getFcport() {
		return fcport;
	}

	public void setFcport(String fcport) {
		this.fcport = fcport;
	}

	public String getHbaWwn() {
		return hbaWwn;
	}

	public void setHbaWwn(String hbaWwn) {
		this.hbaWwn = hbaWwn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

}
