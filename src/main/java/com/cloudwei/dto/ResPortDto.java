package com.cloudwei.dto;

import com.cloudwei.entity.ResPort;
import com.cloudwei.entity.Storage;
import com.cloudwei.entity.Switch;
import com.google.common.base.Function;

public class ResPortDto extends BaseDto{
	
	public static Function<ResPort, ResPortDto> list=
			new	Function<ResPort, ResPortDto>() {
		 @Override
			public ResPortDto apply(ResPort resPort){
				ResPortDto dto = new ResPortDto();
				if (resPort == null){
					return dto;
				}
				dto.setId(resPort.getId());
				dto.setElementName(resPort.getElementName());
				dto.setName(resPort.getName());
				dto.setStatus(resPort.getStatus());
//				dto.setStorage1(resPort.getStorage());
//				dto.setSwitch1(resPort.getSwitch2());
				return dto;
			}
			}; 
	public static Function<ResPort, ResPortDto> detail =
			new Function<ResPort, ResPortDto>() {
		 @Override
			public ResPortDto apply(ResPort resPort) {
				ResPortDto dto = ResPortDto.list.apply(resPort);
				if (resPort == null){
					return dto;
				}
				dto.setStorageElementName(resPort.getStorage().getElementName());
				dto.setSwitchElementName(resPort.getSwitch2().getElementName());
				return dto;
			}
	};
	
	private String elementName;
	private String name;
	private String status;
	private String storageElementName;
	private String switchElementName;
	private Switch switch1;
	private Storage storage1;
	
	public Storage getStorage1() {
		return storage1;
	}
	public void setStorage1(Storage storage1) {
		this.storage1 = storage1;
	}
	public Switch getSwitch1() {
		return switch1;
	}
	public void setSwitch1(Switch switch1) {
		this.switch1 = switch1;
	}
	
	public String getElementName() {
		return elementName;
	}
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStorageElementName() {
		return storageElementName;
	}
	public void setStorageElementName(String storageElementName) {
		this.storageElementName = storageElementName;
	}
	public String getSwitchElementName() {
		return switchElementName;
	}
	public void setSwitchElementName(String switchElementName) {
		this.switchElementName = switchElementName;
	}
	
}
