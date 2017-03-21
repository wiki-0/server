package com.cloudwei.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "T_STORAGE")
public class Storage extends BaseEntity {

    @Column(name = "ELEMENT_NAME")
    private String elementName;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "VENDOR")
    private String vendor;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TVOLUME")
    private long tVolume;

    @Column(name = "TDISK")
    private long tDisk;

    @Column(name = "TCONTROLLER")
    private long tController;

    @Column(name = "TLUNMAPPING")
    private long tLunMapping;

    @Column(name = "TRAIDGROUP")
    private long tRaidGroup;

    @Column(name = "TPORT")
    private long tPort;

    @Column(name = "TVOLUMES")
    private long tVolumes;

    @Column(name = "TDISKS")
    private long tDisks;

    @Column(name = "TCONTROLLERS")
    private long tControllers;

    @Column(name = "TLUNMAPPINGS")
    private long tLunMappings;

    @Column(name = "TRAIDGROUPS")
    private long traidGroups;

    @Column(name = "TPORTS")
    private long tPorts;

    @Column(name = "ALLSTATUS")
    private String allStatus;

    @Column(name = "CODE_LEVEL")
    private String codeLevel;
//报表管理需要查询2个日期内数据，String改Date，当天查询用between
    @Column(name = "patrolTime")
    private Date patrolTime;



    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long gettVolume() {
        return tVolume;
    }

    public void settVolume(long tVolume) {
        this.tVolume = tVolume;
    }

    public long gettDisk() {
        return tDisk;
    }

    public void settDisk(long tDisk) {
        this.tDisk = tDisk;
    }

    public long gettController() {
        return tController;
    }

    public void settController(long tController) {
        this.tController = tController;
    }

    public long gettLunMapping() {
        return tLunMapping;
    }

    public void settLunMapping(long tLunMapping) {
        this.tLunMapping = tLunMapping;
    }

    public long gettRaidGroup() {
        return tRaidGroup;
    }

    public void settRaidGroup(long tRaidGroup) {
        this.tRaidGroup = tRaidGroup;
    }

    public long gettPort() {
        return tPort;
    }

    public void settPort(long tPort) {
        this.tPort = tPort;
    }

    public long gettVolumes() {
        return tVolumes;
    }

    public void settVolumes(long tVolumes) {
        this.tVolumes = tVolumes;
    }

    public long gettDisks() {
        return tDisks;
    }

    public void settDisks(long tDisks) {
        this.tDisks = tDisks;
    }

    public long gettControllers() {
        return tControllers;
    }

    public void settControllers(long tControllers) {
        this.tControllers = tControllers;
    }

    public long gettLunMappings() {
        return tLunMappings;
    }

    public void settLunMappings(long tLunMappings) {
        this.tLunMappings = tLunMappings;
    }

    public long getTraidGroups() {
        return traidGroups;
    }

    public void setTraidGroups(long traidGroups) {
        this.traidGroups = traidGroups;
    }

    public long gettPorts() {
        return tPorts;
    }

    public void settPorts(long tPorts) {
        this.tPorts = tPorts;
    }

    public String getAllStatus() {
        return allStatus;
    }

    public void setAllStatus(String allStatus) {
        this.allStatus = allStatus;
    }

    public Date getPatrolTime() {
		return patrolTime;
	}

	public void setPatrolTime(Date patrolTime) {
		this.patrolTime = patrolTime;
	}

	public String getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(String codeLevel) {
        this.codeLevel = codeLevel;
    }


}
