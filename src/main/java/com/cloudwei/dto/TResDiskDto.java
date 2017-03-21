package com.cloudwei.dto;

import com.cloudwei.entity.TResDisk;
import com.cloudwei.entity.TStorage;
import com.google.common.base.Function;

public class TResDiskDto extends BaseDto {

	private TStorage storageID;
	private String elementName;
	private String status;
	private String model;
	private String vendor;

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

	public TStorage getStorageID() {
		return storageID;
	}

	public void setStorageID(TStorage storageID) {
		this.storageID = storageID;
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

	public static Function<TResDisk, TResDiskDto> list = new Function<TResDisk, TResDiskDto>() {
		public TResDiskDto apply(TResDisk tResDisk) {
			TResDiskDto dto = new TResDiskDto();
			if (tResDisk == null)
				return dto;
			dto.setModel(tResDisk.getModel());
			dto.setVendor(tResDisk.getVendor());
			dto.setElementName(tResDisk.getElementName());
			dto.setStatus(tResDisk.getStatus());

			return dto;
		}
	};

	public static Function<TResDisk, TResDiskDto> detail = new Function<TResDisk, TResDiskDto>() {
		public TResDiskDto apply(TResDisk tResDisk) {
			TResDiskDto dto = new TResDiskDto();
			if (tResDisk == null)
				return dto;

			return dto;
		}
	};

}
