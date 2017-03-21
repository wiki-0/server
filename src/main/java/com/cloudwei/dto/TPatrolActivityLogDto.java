package com.cloudwei.dto;

import com.cloudwei.entity.TPatrolActivityLog;
import com.google.common.base.Function;

public class TPatrolActivityLogDto extends BaseDto {
    public static Function<TPatrolActivityLog, TPatrolActivityLogDto> list =
            new Function<TPatrolActivityLog, TPatrolActivityLogDto>() {

                @Override
                public TPatrolActivityLogDto apply(TPatrolActivityLog TPatrolActivityLog) {
                    TPatrolActivityLogDto dto = new TPatrolActivityLogDto();
                    if (TPatrolActivityLog == null) {
                        return dto;
                    }
                    dto.setId(TPatrolActivityLog.getId());
                    dto.setActivityLogNum(TPatrolActivityLog.getActivityLogNum());
                    dto.setActivityLogState(TPatrolActivityLog.getActivityLogState());
                    dto.setActivityLogTime(TPatrolActivityLog.getPatrolTime());                    
                    return dto;
                }
            };

    public static Function<TPatrolActivityLog, TPatrolActivityLogDto> detail =
            new Function<TPatrolActivityLog, TPatrolActivityLogDto>() {

                @Override
                public TPatrolActivityLogDto apply(TPatrolActivityLog TPatrolActivityLog) {
                    TPatrolActivityLogDto dto = TPatrolActivityLogDto.list.apply(TPatrolActivityLog);
                    if(TPatrolActivityLog==null){
                        return dto;
                    }
                    dto.setActivityLogMsg(TPatrolActivityLog.getActivityLogMsg());
                    dto.setActivityLogNum(TPatrolActivityLog.getActivityLogNum());
                    dto.setActivityLogTime(TPatrolActivityLog.getActivityLogTime());
                    return dto;
                }
        
    };

    private String activityLogTime;
    private String activityLogNum;
    private String activityLogState;
    private String activityLogMsg;
    private long statId;
    private String patrolType;
    private String ip;

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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


}
