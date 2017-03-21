package com.cloudwei.dto;

import com.cloudwei.entity.AlarmPatrol;
import com.google.common.base.Function;

public class AlarmPatrolDto extends BaseDto {
    public static Function<AlarmPatrol, AlarmPatrolDto> list =
            new Function<AlarmPatrol, AlarmPatrolDto>() {

                public AlarmPatrolDto apply(AlarmPatrol alarmPatrol) {
                    AlarmPatrolDto dto = new AlarmPatrolDto();
                    if (alarmPatrol == null)
                        return dto;
                    dto.setId(alarmPatrol.getId());
                    dto.setTapDeviceName(alarmPatrol.getTapDeviceName());
                    dto.setTapFirstOccurence(alarmPatrol.getTapFirstOccurence());
                    dto.setTapLastOccurence(alarmPatrol.getTapLastOccurence());
                    dto.setTapAlarmDescription(alarmPatrol.getTapAlarmDescription());
                    dto.setTapAlarmMessage(alarmPatrol.getTapAlarmDescription());
                    return dto;
                }
            };
    public static Function<AlarmPatrol, AlarmPatrolDto> detail =
            new Function<AlarmPatrol, AlarmPatrolDto>() {

                public AlarmPatrolDto apply(AlarmPatrol alarmPatrol) {
                    // TODO Auto-generated method stub
                    AlarmPatrolDto dto = AlarmPatrolDto.list.apply(alarmPatrol);
                    if (alarmPatrol == null)
                        return dto;
                    dto.setTapFirstOccurence(alarmPatrol.getTapFirstOccurence());
                    dto.setTapLastOccurence(alarmPatrol.getTapLastOccurence());
                    dto.setTapAlarmDescription(alarmPatrol.getTapAlarmDescription());
                    dto.setTapAlarmMessage(alarmPatrol.getTapAlarmDescription());
                    return dto;
                }
            };

    private long tapDeviceId;
    private String tapDeviceName;
    private String tapAlarmDescription;
    private String tapAlarmMessage;
    private String tapDeviceType;
    private String tapFirstOccurence;
    private String tapLastOccurence;

    public long getTapDeviceId() {
        return tapDeviceId;
    }

    public void setTapDeviceId(long tapDeviceId) {
        this.tapDeviceId = tapDeviceId;
    }

    public String getTapDeviceName() {
        return tapDeviceName;
    }

    public void setTapDeviceName(String tapDeviceName) {
        this.tapDeviceName = tapDeviceName;
    }

    public String getTapAlarmDescription() {
        return tapAlarmDescription;
    }

    public void setTapAlarmDescription(String tapAlarmDescription) {
        this.tapAlarmDescription = tapAlarmDescription;
    }

    public String getTapAlarmMessage() {
        return tapAlarmMessage;
    }

    public void setTapAlarmMessage(String tapAlarmMessage) {
        this.tapAlarmMessage = tapAlarmMessage;
    }

    public String getTapDeviceType() {
        return tapDeviceType;
    }

    public void setTapDeviceType(String tapDeviceType) {
        this.tapDeviceType = tapDeviceType;
    }

    public String getTapFirstOccurence() {
        return tapFirstOccurence;
    }

    public void setTapFirstOccurence(String tapFirstOccurence) {
        this.tapFirstOccurence = tapFirstOccurence;
    }

    public String getTapLastOccurence() {
        return tapLastOccurence;
    }

    public void setTapLastOccurence(String tapLastOccurence) {
        this.tapLastOccurence = tapLastOccurence;
    }

}
