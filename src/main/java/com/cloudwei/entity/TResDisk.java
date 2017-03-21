package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_RES_DISK")

public class TResDisk extends BaseEntity {

	@Column(name = "ELEMENT_NAME")
	private String elementName;

	@Column(name = "MODEL")
	private String model;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "VENDOR")
	private String vendor;

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

	@JoinColumn(name = "STORAGE_ID")
	@ManyToOne
	private TStorage storageID;

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
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
