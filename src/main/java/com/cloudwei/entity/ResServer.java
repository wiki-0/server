package com.cloudwei.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_res_server")
public class ResServer extends BaseEntity{

    private String sofeware;
    
    private String serverName;
    
    private String ip;
    
    private Integer port;
    
    private String userName;

    public String getSofeware() {
        return sofeware;
    }

    public void setSofeware(String sofeware) {
        this.sofeware = sofeware;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
