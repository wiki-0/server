package com.cloudwei.dto;

import com.cloudwei.entity.PatrolActivityLog;
import com.google.common.base.Function;

public class PatrolActivityLogDto extends BaseDto {
    public static Function<PatrolActivityLog, PatrolActivityLogDto> list =
            new Function<PatrolActivityLog, PatrolActivityLogDto>() {

                @Override
                public PatrolActivityLogDto apply(PatrolActivityLog patrolActivityLog) {
                    PatrolActivityLogDto dto = new PatrolActivityLogDto();
                    if (patrolActivityLog == null) {
                        return dto;
                    }
                    dto.setId(patrolActivityLog.getId());
                    dto.setIp(patrolActivityLog.getResServer().getIp());
                    dto.setActivityLogNum(patrolActivityLog.getActivityLogNum());
                    dto.setActivityLogState(patrolActivityLog.getActivityLogState());
                    dto.setPatrolTime(patrolActivityLog.getPatrolTime());
                    return dto;
                }
            };

    public static Function<PatrolActivityLog, PatrolActivityLogDto> detail =
            new Function<PatrolActivityLog, PatrolActivityLogDto>() {

                @Override
                public PatrolActivityLogDto apply(PatrolActivityLog patrolActivityLog) {
                    PatrolActivityLogDto dto = PatrolActivityLogDto.list.apply(patrolActivityLog);
                    if(patrolActivityLog==null){
                        return dto;
                    }
                    dto.setActivityLogMsg(patrolActivityLog.getActivityLogMsg());
                    dto.setActivityLogNum(patrolActivityLog.getActivityLogNum());
                    dto.setPatrolTime(patrolActivityLog.getPatrolTime());
                    return dto;
                }
        
    };

    private String patrolTime;
    private String activityLogNum;
    private String activityLogState;
    private String activityLogMsg;
    private long statId;
    private String patrolType;
    private String ip;


    public String getPatrolTime() {
		return patrolTime;
	}

	public void setPatrolTime(String patrolTime) {
		this.patrolTime = patrolTime;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


}
