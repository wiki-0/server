package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_Patrol_Kpi_Task")
public class TPatrolKpiTask extends BaseEntity {
    @Column(name = "TPatrolKpiTask_IP")
    private String tPatrolKpiTaskIp;

    @Column(name = "TPatrolKpiTask_TYPE")
    private String tPatrolKpiTaskType;

    @Column(name = "patroltype")
    private String patrolType;

    @Column(name = "patrolTime")
    private String patrolTime;

    public String gettPatrolKpiTaskIp() {
        return tPatrolKpiTaskIp;
    }

    public void settPatrolKpiTaskIp(String tPatrolKpiTaskIp) {
        this.tPatrolKpiTaskIp = tPatrolKpiTaskIp;
    }

    public String gettPatrolKpiTaskType() {
        return tPatrolKpiTaskType;
    }

    public void settPatrolKpiTaskType(String tPatrolKpiTaskType) {
        this.tPatrolKpiTaskType = tPatrolKpiTaskType;
    }

    public String getPatrolType() {
        return patrolType;
    }

    public void setPatrolType(String patrolType) {
        this.patrolType = patrolType;
    }

    public String getPatrolTime() {
        return patrolTime;
    }

    public void setPatrolTime(String patrolTime) {
        this.patrolTime = patrolTime;
    }


}
