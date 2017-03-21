package com.cloudwei.dto;

import com.cloudwei.entity.TResController;
import com.cloudwei.entity.TStorage;
import com.google.common.base.Function;

public class TResControllerDto extends BaseDto {

	private TStorage storageID;
	private String elementName;
	private String status;

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

	public static Function<TResController, TResControllerDto> list = new Function<TResController, TResControllerDto>() {

		public TResControllerDto apply(TResController tResController) {
			TResControllerDto dto = new TResControllerDto();
			if (tResController == null)
				return dto;

			dto.setElementName(tResController.getElementName());
			dto.setStatus(tResController.getStatus());
			
			return dto;

		}

	};

	public static Function<TResController, TResControllerDto> detail = new Function<TResController, TResControllerDto>() {
		public TResControllerDto apply(TResController tResController) {
			TResControllerDto dto = new TResControllerDto();
			if (tResController == null)
				return dto;

			return dto;

		}
	};

}
