package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_PRF_DSSYSTEM_PATROL")
public class TPrfDssystem extends BaseEntity {

	@Column(name = "TPDP_TOTAL_IO")
	private String tpdpTotalIo;

	@Column(name = "TPDP_TOTAL_KB")
	private String tpdpTotalKb;

	@JoinColumn(name = "STORAGE_ID")
	@ManyToOne
	private TStorage storageID;

	public String getTpdpTotalIo() {
		return tpdpTotalIo;
	}

	public void setTpdpTotalIo(String tadpTotalIo) {
		this.setTpdpTotalIo(tadpTotalIo);
	}

	public String getTpdpTotalKb() {
		return tpdpTotalKb;
	}

	public void setTpdpTotalKb(String tpdpTotalKb) {
		this.tpdpTotalKb = tpdpTotalKb;
	}

	public TStorage getStorageID() {
		return storageID;
	}

	public void setStorageID(TStorage storageID) {
		this.storageID = storageID;
	}

}
