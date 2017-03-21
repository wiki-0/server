package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="T_SWITH_FAN")
public class SwitchFan extends BaseEntity{

	@Column(name="TSwithFan_STATUS")
	private String tSwithFanStatus;
	
	@Column(name="TSwithFan_ENABLED_STATE")
	private String tSwithFanEnabledState;
	
	@Column(name="TSwithFan_VARIABLE_SPEED")
	private String tSwithFanVariableSpeed;
	
	@Column(name="TSwithFan_ACTIVE_COOLING")
	private String tSwithFanActiveCooling;
	
	@Column(name="TSwithFan_PHYSICAL_PACKAGE_ID")
	private String tSwithFanPhysicalPackageId;
	
	@Column(name="TSwithFan_SERIAL_NUMBER")
	private String tSwithFanSerialNumber;
	
	@Column(name="TSwithFan_SPEED")
	private String tSwithFanSpeed;
	
	@JoinColumn(name="switchPatrol_id")
	@ManyToOne
	private Switch switchPatrol;

	public String gettSwithFanStatus() {
		return tSwithFanStatus;
	}

	public void settSwithFanStatus(String tSwithFanStatus) {
		this.tSwithFanStatus = tSwithFanStatus;
	}

	public String gettSwithFanEnabledState() {
		return tSwithFanEnabledState;
	}

	public void settSwithFanEnabledState(String tSwithFanEnabledState) {
		this.tSwithFanEnabledState = tSwithFanEnabledState;
	}

	public String gettSwithFanVariableSpeed() {
		return tSwithFanVariableSpeed;
	}

	public void settSwithFanVariableSpeed(String tSwithFanVariableSpeed) {
		this.tSwithFanVariableSpeed = tSwithFanVariableSpeed;
	}

	public String gettSwithFanActiveCooling() {
		return tSwithFanActiveCooling;
	}

	public void settSwithFanActiveCooling(String tSwithFanActiveCooling) {
		this.tSwithFanActiveCooling = tSwithFanActiveCooling;
	}

	public String gettSwithFanPhysicalPackageId() {
		return tSwithFanPhysicalPackageId;
	}

	public void settSwithFanPhysicalPackageId(String tSwithFanPhysicalPackageId) {
		this.tSwithFanPhysicalPackageId = tSwithFanPhysicalPackageId;
	}

	public String gettSwithFanSerialNumber() {
		return tSwithFanSerialNumber;
	}

	public void settSwithFanSerialNumber(String tSwithFanSerialNumber) {
		this.tSwithFanSerialNumber = tSwithFanSerialNumber;
	}

	public String gettSwithFanSpeed() {
		return tSwithFanSpeed;
	}

	public void settSwithFanSpeed(String tSwithFanSpeed) {
		this.tSwithFanSpeed = tSwithFanSpeed;
	}

	public Switch getSwitchPatrol() {
		return switchPatrol;
	}

	public void setSwitchPatrol(Switch switchPatrol) {
		this.switchPatrol = switchPatrol;
	}

	
	
}
