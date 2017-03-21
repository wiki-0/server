package com.cloudwei.dto;

import java.util.Date;

import com.cloudwei.entity.Switch;
import com.google.common.base.Function;

public class SwitchDto extends BaseDto {
    public static Function<Switch, SwitchDto> list = new Function<Switch, SwitchDto>() {
        public SwitchDto apply(Switch switch1) {
            SwitchDto dto = new SwitchDto();
            if (switch1 == null) {
                return dto;
            }
            dto.setId(switch1.getId());
            dto.setAllStatus(switch1.getAllStatus());
            dto.setElementName(switch1.getElementName());
            dto.setIpAddress(switch1.getIpAddress());
            dto.setModel(switch1.getModel());
            dto.setName(switch1.getName());
            dto.setPatrolTime(switch1.getPatrolTime());
            dto.setStatus(switch1.getStatus());
            dto.settPort(switch1.gettPort());
            dto.settPorts(switch1.gettPorts());
            dto.setVendor(switch1.getVendor());
            dto.setVersion(switch1.getVersion());
            return dto;
        }
    };


    private String elementName;
    private String model;
    private String vendor;
    private String status;
    private String allStatus;
    private String name;
    private String ipAddress;
    private long tPort;
    private long tPorts;
    private Date patrolTime;
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
