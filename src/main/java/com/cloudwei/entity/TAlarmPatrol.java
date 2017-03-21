package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_ALARM_PATROL")

public class TAlarmPatrol extends BaseEntity {

	@Column(name = "TAP_ALARM_DESCRIPTION")
	private String tapAlarmDescription;

	@Column(name = "TAP_ALARM_MESSAGE")
	private String tapAlarmMessage;

	@Column(name = "TAP_DEVICE_ID")
	private Long tapDeviceID;

	@Column(name = "TAP_DEVICE_NAME")
	private String tapDeviceName;

	@Column(name = "TAP_DEVICE_TYPE")
	private String tapDeviceType;

	@Column(name = "TAP_FIRST_OCCURENCE")
	private String tapFirstOccurence;

	@Column(name = "TAP_LAST_OCCURENCE")
	private String tapLastOccurence;

	public String getTapAlarmDescription() {
		return tapAlarmDescription;
	}

	public void setTapAlarmDescription(String tapAlarmDescription) {
		this.tapAlarmDescription = tapAlarmDescription;
	}

	public String getTapAlarmMessage() {
		return tapAlarmMessage;
	}

	public void setTapAlarmMessage(String tapAlarmMessage) {
		this.tapAlarmMessage = tapAlarmMessage;
	}

	public Long getTapDeviceID() {
		return tapDeviceID;
	}

	public void setTapDeviceID(Long tapDeviceID) {
		this.tapDeviceID = tapDeviceID;
	}

	public String getTapDeviceName() {
		return tapDeviceName;
	}

	public void setTapDeviceName(String tapDeviceName) {
		this.tapDeviceName = tapDeviceName;
	}

	public String getTapDeviceType() {
		return tapDeviceType;
	}

	public void setTapDeviceType(String tapDeviceType) {
		this.tapDeviceType = tapDeviceType;
	}

	public String getTapFirstOccurence() {
		return tapFirstOccurence;
	}

	public void setTapFirstOccurence(String tapFirstOccurence) {
		this.tapFirstOccurence = tapFirstOccurence;
	}

	public String getTapLastOccurence() {
		return tapLastOccurence;
	}

	public void setTapLastOccurence(String tapLastOccurence) {
		this.tapLastOccurence = tapLastOccurence;
	}
}
