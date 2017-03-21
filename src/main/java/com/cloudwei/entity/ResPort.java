package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_RES_PORT")
public class ResPort extends BaseEntity{
		
	@Column(name="ELEMENT_NAME")
	private String elementName;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="STATUS")
	private String status;
	
	@JoinColumn(name="storage_id")
	@OneToOne(fetch=FetchType.LAZY)
	private Storage storage;
	
	@JoinColumn(name="switch2_id")
	@OneToOne(fetch=FetchType.LAZY)
	private Switch switch2;

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public Switch getSwitch2() {
		return switch2;
	}

	public void setSwitch2(Switch switch2) {
		this.switch2 = switch2;
	}
	
	
}
