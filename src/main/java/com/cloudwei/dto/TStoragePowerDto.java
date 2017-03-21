package com.cloudwei.dto;

import com.cloudwei.entity.TStorage;
import com.cloudwei.entity.TStoragePower;
import com.google.common.base.Function;

public class TStoragePowerDto extends BaseDto {

	private String tspsStatus;
	private String tspsEnabledState;
	private String tspsTotalOutputPower;
	private String tspsPhysicalPackageId;
	private String tspsSerialNumber;
	private String switchPatrol;
	private TStorage storageID;

	public String getTspsStatus() {
		return tspsStatus;
	}

	public void setTspsStatus(String tspsStatus) {
		this.tspsStatus = tspsStatus;
	}

	public String getTspsEnabledState() {
		return tspsEnabledState;
	}

	public void setTspsEnabledState(String tspsEnabledState) {
		this.tspsEnabledState = tspsEnabledState;
	}

	public String getTspsTotalOutputPower() {
		return tspsTotalOutputPower;
	}

	public void setTspsTotalOutputPower(String tspsTotalOutputPower) {
		this.tspsTotalOutputPower = tspsTotalOutputPower;
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

	public String getSwitchPatrol() {
		return switchPatrol;
	}

	public void setSwitchPatrol(String switchPatrol) {
		this.switchPatrol = switchPatrol;
	}

	public TStorage getStorageID() {
		return storageID;
	}

	public void setStorageID(TStorage storageID) {
		this.storageID = storageID;
	}

	public static Function<TStoragePower, TStoragePowerDto> list = new Function<TStoragePower, TStoragePowerDto>() {
		public TStoragePowerDto apply(TStoragePower tStoragePower) {
			TStoragePowerDto dto = new TStoragePowerDto();
			if (tStoragePower == null)
				return dto;

			dto.setTspsSerialNumber(tStoragePower.getTspsSerialNumber());
			dto.setTspsStatus(tStoragePower.getTspsStatus());
			dto.setTspsEnabledState(tStoragePower.getTspsEnabledState());
			dto.setTspsTotalOutputPower(tStoragePower.getTspsTotalOutputPower());

			return dto;

		}
	};

	public static Function<TStoragePower, TStoragePowerDto> detail = new Function<TStoragePower, TStoragePowerDto>() {
		public TStoragePowerDto apply(TStoragePower tStoragePower) {
			TStoragePowerDto dto = new TStoragePowerDto();
			if (tStoragePower == null)
				return dto;

			return dto;
		}
	};
}
