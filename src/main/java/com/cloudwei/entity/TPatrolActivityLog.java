package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_PATROL_ACTIVITYLOG")
public class TPatrolActivityLog extends BaseEntity {
    @Column(name = "ACTIVITYLOG_TIME")
    private String activityLogTime;

    @Column(name = "ACTIVITYLOG_NUM")
    private String activityLogNum;

    @Column(name = "ACTIVITYLOG_STATE")
    private String activityLogState;

    @Column(name = "ACTIVITYLOG_MSG")
    private String activityLogMsg;

    @Column(name = "STAT_ID")
    private long statId;

    @Column(name = "PATROLTYPE")
    private String patrolType;

    @Column(name = "PATROL_TIME")
    private String patrolTime;

    @Column(name = "tResServer_id")
    private String serverId;

	public String getActivityLogTime() {
		return activityLogTime;
	}

	public void setActivityLogTime(String activityLogTime) {
		this.activityLogTime = activityLogTime;
	}

	public String getActivityLogNum() {
		return activityLogNum;
	}

	public void setActivityLogNum(String activityLogNum) {
		this.activityLogNum = activityLogNum;
	}

	public String getActivityLogState() {
		return activityLogState;
	}

	public void setActivityLogState(String activityLogState) {
		this.activityLogState = activityLogState;
	}

	public String getActivityLogMsg() {
		return activityLogMsg;
	}

	public void setActivityLogMsg(String activityLogMsg) {
		this.activityLogMsg = activityLogMsg;
	}

	public long getStatId() {
		return statId;
	}

	public void setStatId(long statId) {
		this.statId = statId;
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

	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
    

}
