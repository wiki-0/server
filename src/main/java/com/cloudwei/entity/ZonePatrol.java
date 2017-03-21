package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_ZONE_PATROL")
public class ZonePatrol extends BaseEntity{
	
	@Column(name="TZP_ACTIVE")
	private int tzpActive;
	
	@Column(name="TZP_NAME")
	private String tzpName;
	
	@JoinColumn(name="switchPatrol_id")
	@ManyToOne
	private Switch switchPatrol;

	public int getTzpActive() {
		return tzpActive;
	}

	public void setTzpActive(int tzpActive) {
		this.tzpActive = tzpActive;
	}

	public String getTzpName() {
		return tzpName;
	}

	public void setTzpName(String tzpName) {
		this.tzpName = tzpName;
	}

	public Switch getSwitchPatrol() {
		return switchPatrol;
	}

	public void setSwitchPatrol(Switch switchPatrol) {
		this.switchPatrol = switchPatrol;
	}

	

}
