package com.cloudwei.dto;

import com.cloudwei.entity.Switch;
import com.cloudwei.entity.SwitchPower;
import com.google.common.base.Function;

public class SwitchPowerDto extends BaseDto{
	
	
		public static Function<SwitchPower, SwitchPowerDto> list=
			new Function<SwitchPower, SwitchPowerDto>() {
				
				@Override
				public SwitchPowerDto  apply(SwitchPower switchPower){
					
					SwitchPowerDto dto=new SwitchPowerDto();
					
					if(switchPower==null)
						return dto;
					
					dto.setId(switchPower.getId());
					dto.setTspsStatus(switchPower.getTspsStatus());
					dto.setTspsTotalOutputPower(switchPower.getTspsTotalOutputPower());
					dto.setTspsEnabledState(switchPower.getTspsEnabledState());
					dto.setTspsSerialNumber(switchPower.getTspsSerialNumber());
					
					
					return dto;
				}
			};
			
			public static Function<SwitchPower, SwitchPowerDto> detail=
					new Function<SwitchPower, SwitchPowerDto>() {
						
						@Override
						public SwitchPowerDto  apply(SwitchPower switchPower){
							
							SwitchPowerDto dto=SwitchPowerDto.list.apply(switchPower);
							
							if(switchPower==null)
								return dto;
							
							dto.setTspsStatus(switchPower.getTspsStatus());
							dto.setTspsTotalOutputPower(switchPower.getTspsTotalOutputPower());
							dto.setTspsEnabledState(switchPower.getTspsEnabledState());
							dto.setElementName(switchPower.getSwitchPatrol().getElementName());
							
							return dto;
						}
					};
			
		private String tspsStatus;
		private String tspsPhysicalPackageId;
		private String tspsSerialNumber;
		private String tspsTotalOutputPower;
		
		private Switch switchPatrol;
		private String elementName;
		
		private String tspsEnabledState;
		
		public String getTspsEnabledState() {
			return tspsEnabledState;
		}
		public void setTspsEnabledState(String tspsEnabledState) {
			this.tspsEnabledState = tspsEnabledState;
		}
		public String getElementName() {
			return elementName;
		}
		public void setElementName(String elementName) {
			this.elementName = elementName;
		}
		public Switch getSwitchPatrol() {
			return switchPatrol;
		}
		public void setSwitchPatrol(Switch switchPatrol) {
			this.switchPatrol = switchPatrol;
		}
		public String getTspsStatus() {
			return tspsStatus;
		}
		public void setTspsStatus(String tspsStatus) {
			this.tspsStatus = tspsStatus;
		}
		public String getTspsPhysicalPackageId() {
			return tspsPhysicalPackageId;
		}
		public void setTspsPhysicalPackageId(String tspsPhysicalPackageId) {
			this.tspsPhysicalPackageId = tspsPhysicalPackageId;
		}
		public String getTspsSerialNumber() {
			return tspsSerialNumber;
		}
		public void setTspsSerialNumber(String tspsSerialNumber) {
			this.tspsSerialNumber = tspsSerialNumber;
		}
		public String getTspsTotalOutputPower() {
			return tspsTotalOutputPower;
		}
		public void setTspsTotalOutputPower(String tspsTotalOutputPower) {
			this.tspsTotalOutputPower = tspsTotalOutputPower;
		}
}
