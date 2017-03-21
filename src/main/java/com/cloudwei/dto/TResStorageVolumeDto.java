package com.cloudwei.dto;

import com.cloudwei.entity.TResStorageVolume;
import com.cloudwei.entity.TStorage;
import com.google.common.base.Function;

public class TResStorageVolumeDto {

	private long capacity;
	private String elementName;
	private String status;
	private TStorage storageID;

	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TStorage getStorageID() {
		return storageID;
	}

	public void setStorageID(TStorage storageID) {
		this.storageID = storageID;
	}

	public static Function<TResStorageVolume, TResStorageVolumeDto> list = new Function<TResStorageVolume, TResStorageVolumeDto>() {

		public TResStorageVolumeDto apply(TResStorageVolume tResStorageVolume) {
			TResStorageVolumeDto dto = new TResStorageVolumeDto();
			if (tResStorageVolume == null)
				return dto;

			dto.setElementName(tResStorageVolume.getElementName());
			dto.setCapacity(tResStorageVolume.getCapacity());
			dto.setStatus(tResStorageVolume.getStatus());
			return dto;
		}
	};

	public static Function<TResStorageVolume, TResStorageVolumeDto> detail = new Function<TResStorageVolume, TResStorageVolumeDto>() {

		public TResStorageVolumeDto apply(TResStorageVolume tResStorageVolume) {
			// TODO Auto-generated method stub
			TResStorageVolumeDto dto = TResStorageVolumeDto.list.apply(tResStorageVolume);
			if (tResStorageVolume == null)
				return dto;

			return dto;
		}
	};
}
