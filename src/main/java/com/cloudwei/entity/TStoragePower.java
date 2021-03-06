package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_SWITH_POWER")
public class TStoragePower extends BaseEntity {

	@Column(name = "TSPS_STATUS")
	private String tspsStatus;

	@Column(name = "TSPS_ENABLED_STATE")
	private String tspsEnabledState;

	@Column(name = "TSPS_TOTAL_OUTPUT_POWER")
	private String tspsTotalOutputPower;

	@Column(name = "TSPS_PHYSICAL_PACKAGE_ID")
	private String tspsPhysicalPackageId;

	@Column(name = "TSPS_SERIAL_NUMBER")
	private String tspsSerialNumber;

	@Column(name = "SWITCHPATROL_ID")
	private String switchPatrol;

	@JoinColumn(name = "STORAGE_ID")
	@ManyToOne
	private TStorage storageID;

	public String getTspsStatus() {
		return tspsStatus;
	}

	public void setTspsStatus(String tspsStatus) {
		this.tspsStatus = tspsStatus;
	}

	public String getTspsEnabledState() {
		return tspsEnabledState;
	}

	public void setTspsEnabledState(String tspsEnabledState) {
		this.tspsEnabledState = tspsEnabledState;
	}

	public String getTspsTotalOutputPower() {
		return tspsTotalOutputPower;
	}

	public void setTspsTotalOutputPower(String tspsTotalOutputPower) {
		this.tspsTotalOutputPower = tspsTotalOutputPower;
	}

	public String getTspsPhysicalPackageId() {
		return tspsPhysicalPackageId;
	}

	public void setTspsPhysicalPackageId(String tspsPhysicalPackageId) {
		this.tspsPhysicalPackageId = tspsPhysicalPackageId;
	}

	public String getTspsSerialNumber() {
		return tspsSerialNumber;
	}

	public void setTspsSerialNumber(String tspsSerialNumber) {
		this.tspsSerialNumber = tspsSerialNumber;
	}

	public String getSwitchPatrol() {
		return switchPatrol;
	}

	public void setSwitchPatrol(String switchPatrol) {
		this.switchPatrol = switchPatrol;
	}

	public TStorage getStorageID() {
		return storageID;
	}

	public void setStorageID(TStorage storageID) {
		this.storageID = storageID;
	}

	

}
