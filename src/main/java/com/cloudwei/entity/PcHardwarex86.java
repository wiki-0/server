package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_PC_HARDWAR")
public class PcHardwarex86 extends BaseEntity {
    @Column(name = "pcHardware_ip")
    private String pcHardWareIp;
    @Column(name = "pcHardware_Content")
    private String pcHardWareContent;
    @Column(name = "patrolTime")
    private String patrolTime;

    public String getPcHardWareIp() {
        return pcHardWareIp;
    }

    public void setPcHardWareIp(String pcHardWareIp) {
        this.pcHardWareIp = pcHardWareIp;
    }

    public String getPcHardWareContent() {
        return pcHardWareContent;
    }

    public void setPcHardWareContent(String pcHardWareContent) {
        this.pcHardWareContent = pcHardWareContent;
    }

    public String getPatrolTime() {
        return patrolTime;
    }

    public void setPatrolTime(String patrolTime) {
        this.patrolTime = patrolTime;
    }

}
