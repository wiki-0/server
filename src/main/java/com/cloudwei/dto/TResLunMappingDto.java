package com.cloudwei.dto;

import com.cloudwei.entity.TResLunMapping;
import com.cloudwei.entity.TStorage;
import com.google.common.base.Function;

public class TResLunMappingDto extends BaseDto {

	private String hostName;
	private String volume;
	private TStorage storageID;
	private String fcport;
	private String hbaWwn;
	private String status;

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public TStorage getStorageID() {
		return storageID;
	}

	public void setStorageID(TStorage storageID) {
		this.storageID = storageID;
	}

	public String getFcport() {
		return fcport;
	}

	public void setFcport(String fcport) {
		this.fcport = fcport;
	}

	public String getHbaWwn() {
		return hbaWwn;
	}

	public void setHbaWwn(String hbaWwn) {
		this.hbaWwn = hbaWwn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static Function<TResLunMapping, TResLunMappingDto> list = new Function<TResLunMapping, TResLunMappingDto>() {
		public TResLunMappingDto apply(TResLunMapping tResLunMapping) {
			TResLunMappingDto dto = new TResLunMappingDto();
			if (tResLunMapping == null)
				return dto;
			dto.setHostName(tResLunMapping.getHostName());
			dto.setVolume(tResLunMapping.getVolume());
			dto.setFcport(tResLunMapping.getFcport());
			dto.setHbaWwn(tResLunMapping.getHbaWwn());
			dto.setStatus(tResLunMapping.getStatus());
			return dto;
		}
	};

	public static Function<TResLunMapping, TResLunMappingDto> detail = new Function<TResLunMapping, TResLunMappingDto>() {
		public TResLunMappingDto apply(TResLunMapping tResLunMapping) {
			TResLunMappingDto dto = new TResLunMappingDto();
			if (tResLunMapping == null)
				return dto;

			return dto;

		}
	};

}
