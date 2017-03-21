package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_RES_CONTROLLER")
public class TResController extends BaseEntity {

	@Column(name = "ELEMENT_NAME")
	private String elementName;

	@Column(name = "STATUS")
	private String status;

	@JoinColumn(name = "STORAGE_ID")
	@ManyToOne
	private TStorage storageID;

	public TStorage getStorageID() {
		return storageID;
	}

	public void setStorageID(TStorage storageID) {
		this.storageID = storageID;
	}

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

	

}
