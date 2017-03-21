package com.cloudwei.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "T_Switch")
public class Switch extends BaseEntity {

    @Column(name = "ELEMENT_NAME")
    private String elementName;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "VENDOR")
    private String vendor;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "ALLSTATUS")
    private String allStatus;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IP_ADDRESS")
    private String ipAddress;

    @Column(name = "TPORT")
    private long tPort;

    @Column(name = "TPORTS")
    private long tPorts;

    @Column(name = "patrolTime")
    private Date patrolTime;

    @Column(name = "VERSION")
    private String version;

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

    public String getAllStatus() {
        return allStatus;
    }

    public void setAllStatus(String allStatus) {
        this.allStatus = allStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public long gettPort() {
        return tPort;
    }

    public void settPort(long tPort) {
        this.tPort = tPort;
    }

    public long gettPorts() {
        return tPorts;
    }

    public void settPorts(long tPorts) {
        this.tPorts = tPorts;
    }

    public Date getPatrolTime() {
		return patrolTime;
	}

	public void setPatrolTime(Date patrolTime) {
		this.patrolTime = patrolTime;
	}

	public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }



}
