package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_RES_RAIDGROUP")

public class TResRaidgroup extends BaseEntity {

	@Column(name = "NAME")
	private String name;

	@Column(name = "RAID_LEVEL")
	private String raidLevel;

	@Column(name = "STATUS")
	private String status;

	@JoinColumn(name = "STORAGE_ID")
	@ManyToOne
	private TStorage storageID;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRaidLevel() {
		return raidLevel;
	}

	public void setRaidLevel(String raidLevel) {
		this.raidLevel = raidLevel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TStorage getStorageID() {
		return storageID;
	}

	public void setStorageID(TStorage storageID) {
		this.storageID = storageID;
	}

}
