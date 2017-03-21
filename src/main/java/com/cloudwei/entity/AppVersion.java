package com.cloudwei.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="app_version")
public class AppVersion extends BaseEntity{
    private String version;
    private Date date;
    private String log;
    private String androidCloudPath;
    private String iosCloudPath;
    private String updatePath;
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getLog() {
        return log;
    }
    public void setLog(String log) {
        this.log = log;
    }
    public String getAndroidCloudPath() {
        return androidCloudPath;
    }
    public void setAndroidCloudPath(String androidCloudPath) {
        this.androidCloudPath = androidCloudPath;
    }
    public String getIosCloudPath() {
        return iosCloudPath;
    }
    public void setIosCloudPath(String iosCloudPath) {
        this.iosCloudPath = iosCloudPath;
    }
    public String getUpdatePath() {
        return updatePath;
    }
    public void setUpdatePath(String updatePath) {
        this.updatePath = updatePath;
    }
    
}
