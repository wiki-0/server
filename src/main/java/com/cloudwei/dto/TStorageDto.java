package com.cloudwei.dto;

import com.cloudwei.entity.TStorage;
import com.google.common.base.Function;

public class TStorageDto extends BaseDto {

	private String model;
	private String vendor;
	private String status;
	private String allStatus;
	private String elementName;
	private String patrolTime;
	private String codeLevel;
	private String volumes;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAllStatus() {
		return allStatus;
	}

	public void setAllStatus(String allStatus) {
		this.allStatus = allStatus;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public String getPatrolTime() {
		return patrolTime;
	}

	public void setPatrolTime(String patrolTime) {
		this.patrolTime = patrolTime;
	}

	public String getCodeLevel() {
		return codeLevel;
	}

	public void setCodeLevel(String codeLevel) {
		this.codeLevel = codeLevel;
	}

	public String getVolumes() {
		return volumes;
	}

	public void setVolumes(String volumes) {
		this.volumes = volumes;
	}

	public static Function<TStorage, TStorageDto> list = new Function<TStorage, TStorageDto>() {
		public TStorageDto apply(TStorage tStorage) {
			TStorageDto dto = new TStorageDto();
			if (tStorage == null)
				return dto;
			dto.setId(tStorage.getId());
			dto.setAllStatus(tStorage.getAllStatus());
			dto.setElementName(tStorage.getElementName());
			dto.setPatrolTime(tStorage.getPatrolTime());
			dto.setCodeLevel(tStorage.getCodeLevel());
			dto.setVolumes(tStorage.getVolumes());
			dto.setModel(tStorage.getModel());
			dto.setVendor(tStorage.getVendor());
			dto.setStatus(tStorage.getStatus());
			return dto;

		}
	};

	public static Function<TStorage, TStorageDto> detail = new Function<TStorage, TStorageDto>() {
		public TStorageDto apply(TStorage tStorage) {
			TStorageDto dto = new TStorageDto();
			if (tStorage == null)
				return dto;
			dto.setElementName(tStorage.getElementName());
			dto.setPatrolTime(tStorage.getPatrolTime());
			dto.setCodeLevel(tStorage.getCodeLevel());
			dto.setVolumes(tStorage.getVolumes());
			return dto;
		}
	};
}
