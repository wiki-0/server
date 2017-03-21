package com.cloudwei.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="T_ALARM")

public class TAlarm extends BaseEntity{
	@Column(name="ALARM_DESCRIP")
	private String alarmDescrip;
	
	@Column(name="ALARM_MESSAGE")
	private String alarmMessage;
	
	@Column(name="FIRST_OCCUREN")
	private Date firstOccuren;
	
	@Column(name="LAST_OCCUREN")
	private Date lastOccuren;
	
	@Column(name="DEVICE_NAME")
	private String deviceName;
	
	@Column(name="Device_Id")
	private long deciveId;
	
	@Column(name="Id")
	private long id;
	
	@Column(name="DeviceType")
	private String deviceType;

	
	
	public String getAlarmDescrip() {
		return alarmDescrip;
	}

	public void setAlarmDescrip(String alarmDescrip) {
		this.alarmDescrip = alarmDescrip;
	}

	public String getAlarmMessage() {
		return alarmMessage;
	}

	public void setAlarmMessage(String alarmMessage) {
		this.alarmMessage = alarmMessage;
	}

	public Date getFirstOccuren() {
		return firstOccuren;
	}

	public void setFirstOccuren(Date firstOccuren) {
		this.firstOccuren = firstOccuren;
	}

	public Date getLastOccuren() {
		return lastOccuren;
	}

	public void setLastOccuren(Date lastOccuren) {
		this.lastOccuren = lastOccuren;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public long getDeciveId() {
		return deciveId;
	}

	public void setDeciveId(long deciveId) {
		this.deciveId = deciveId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	

	
}

