package com.cloudwei.dto;

import com.cloudwei.entity.TPrfDssystem;
import com.cloudwei.entity.TStorage;
import com.google.common.base.Function;

public class TPrfDssystemDto extends BaseDto {

	private String tpdpTotalIo;
	private String tpdpTotalKb;
	private TStorage storageID;

	public String getTpdpTotalIo() {
		return tpdpTotalIo;
	}

	public void setTpdpTotalIo(String tpdpTotalIo) {
		this.tpdpTotalIo = tpdpTotalIo;
	}

	public String getTpdpTotalKb() {
		return tpdpTotalKb;
	}

	public void setTpdpTotalKb(String tpdpTotalKb) {
		this.tpdpTotalKb = tpdpTotalKb;
	}

	public TStorage getStorageID() {
		return storageID;
	}

	public void setStorageID(TStorage storageID) {
		this.storageID = storageID;
	}

	public static Function<TPrfDssystem, TPrfDssystemDto> list = new Function<TPrfDssystem, TPrfDssystemDto>() {
		public TPrfDssystemDto apply(TPrfDssystem tPrfDssystem) {
			TPrfDssystemDto dto = new TPrfDssystemDto();
			if (tPrfDssystem == null)
				return dto;
			dto.setTpdpTotalIo(tPrfDssystem.getTpdpTotalIo());
			dto.setTpdpTotalKb(tPrfDssystem.getTpdpTotalKb());
			return dto;

		}
	};

	public static Function<TPrfDssystem, TPrfDssystemDto> detail = new Function<TPrfDssystem, TPrfDssystemDto>() {
		public TPrfDssystemDto apply(TPrfDssystem tPrfDssystem) {
			TPrfDssystemDto dto = new TPrfDssystemDto();
			if (tPrfDssystem == null)
				return dto;
			return dto;
		}
	};

}
