package com.cloudwei.dto;

import com.cloudwei.entity.SwitchFan;
import com.google.common.base.Function;

public class SwitchFanDto extends BaseDto {
	
	public static Function<SwitchFan, SwitchFanDto> list=
			new Function<SwitchFan, SwitchFanDto>() {
				
				@Override
				public SwitchFanDto  apply(SwitchFan switchFan){
					
					SwitchFanDto dto=new SwitchFanDto();
					
					if(switchFan==null)
						return dto;
					
					dto.setId(switchFan.getId());
					dto.settSwithFanSerialNumber(switchFan.gettSwithFanSerialNumber());
					dto.settSwithFanEnabledState(switchFan.gettSwithFanEnabledState());
					dto.settSwithFanVariableSpeed(switchFan.gettSwithFanVariableSpeed());
					dto.settSwithFanSpeed(switchFan.gettSwithFanSpeed());
					dto.settSwithFanStatus(switchFan.gettSwithFanStatus());
					
					return dto;
				}
			};
			
			
	public static Function<SwitchFan, SwitchFanDto> detail=
			new Function<SwitchFan, SwitchFanDto>() {
				
				@Override
				public SwitchFanDto  apply(SwitchFan switchFan){
					
					SwitchFanDto dto=SwitchFanDto.list.apply(switchFan);
					
					if(switchFan==null)
						return dto;
					
					dto.settSwithFanSpeed(switchFan.gettSwithFanSpeed());
					dto.settSwithFanStatus(switchFan.gettSwithFanStatus());
					
					return dto;
				}
			};
	
	private String tSwithFanSerialNumber;
	private String tSwithFanSpeed;
	private String tSwithFanStatus;
	private String tSwithFanEnabledState;
	private String tSwithFanVariableSpeed;
	
	public String gettSwithFanEnabledState() {
		return tSwithFanEnabledState;
	}
	public void settSwithFanEnabledState(String tSwithFanEnabledState) {
		this.tSwithFanEnabledState = tSwithFanEnabledState;
	}
	public String gettSwithFanVariableSpeed() {
		return tSwithFanVariableSpeed;
	}
	public void settSwithFanVariableSpeed(String tSwithFanVariableSpeed) {
		this.tSwithFanVariableSpeed = tSwithFanVariableSpeed;
	}
	public String gettSwithFanSerialNumber() {
		return tSwithFanSerialNumber;
	}
	public void settSwithFanSerialNumber(String tSwithFanSerialNumber) {
		this.tSwithFanSerialNumber = tSwithFanSerialNumber;
	}
	
	public String gettSwithFanSpeed() {
		return tSwithFanSpeed;
	}
	public void settSwithFanSpeed(String tSwithFanSpeed) {
		this.tSwithFanSpeed = tSwithFanSpeed;
	}
	public String gettSwithFanStatus() {
		return tSwithFanStatus;
	}
	public void settSwithFanStatus(String tSwithFanStatus) {
		this.tSwithFanStatus = tSwithFanStatus;
	}
	
	
}
