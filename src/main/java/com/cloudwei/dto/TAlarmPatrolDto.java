package com.cloudwei.dto;

import com.cloudwei.entity.TAlarmPatrol;
import com.google.common.base.Function;

public class TAlarmPatrolDto extends BaseDto {

	private String tapAlarmDescription;
	private String tapAlarmMessage;
	private Long tapDeviceID;
	private String tapDeviceName;
	private String tapDeviceType;
	private String tapFirstOccurence;
	private String tapLastOccurence;

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

	public Long getTapDeviceID() {
		return tapDeviceID;
	}

	public void setTapDeviceID(Long tapDeviceID) {
		this.tapDeviceID = tapDeviceID;
	}

	public String getTapDeviceName() {
		return tapDeviceName;
	}

	public void setTapDeviceName(String tapDeviceName) {
		this.tapDeviceName = tapDeviceName;
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

	public static Function<TAlarmPatrol, TAlarmPatrolDto> list = new Function<TAlarmPatrol, TAlarmPatrolDto>() {

		public TAlarmPatrolDto apply(TAlarmPatrol tAlarmPatrol) {
			TAlarmPatrolDto dto = new TAlarmPatrolDto();
			if (tAlarmPatrol == null)
				return dto;

			dto.setTapDeviceName(tAlarmPatrol.getTapDeviceName());
			dto.setTapAlarmMessage(tAlarmPatrol.getTapAlarmMessage());
			dto.setTapAlarmDescription(tAlarmPatrol.getTapAlarmDescription());
			dto.setTapFirstOccurence(tAlarmPatrol.getTapFirstOccurence());
			dto.setTapLastOccurence(tAlarmPatrol.getTapLastOccurence());

			return dto;
		}
	};

	public static Function<TAlarmPatrol, TAlarmPatrolDto> detail = new Function<TAlarmPatrol, TAlarmPatrolDto>() {

		public TAlarmPatrolDto apply(TAlarmPatrol tAlarmPatrol) {
			// TODO Auto-generated method stub
			TAlarmPatrolDto dto = TAlarmPatrolDto.list.apply(tAlarmPatrol);
			if (tAlarmPatrol == null)
				return dto;

			return dto;
		}
	};

}
