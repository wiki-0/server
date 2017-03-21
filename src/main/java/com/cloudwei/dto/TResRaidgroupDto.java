package com.cloudwei.dto;

import com.cloudwei.entity.TResRaidgroup;
import com.cloudwei.entity.TStorage;
import com.google.common.base.Function;

public class TResRaidgroupDto extends BaseDto {

	private String name;
	private String raidLevel;
	private TStorage storageID;
	private String status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRaidLevel() {
		return raidLevel;
	}

	public void setRaidLevel(String raidLevel) {
		this.raidLevel = raidLevel;
	}

	public TStorage getStorageID() {
		return storageID;
	}

	public void setStorageID(TStorage storageID) {
		this.storageID = storageID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static Function<TResRaidgroup, TResRaidgroupDto> list = new Function<TResRaidgroup, TResRaidgroupDto>() {
		public TResRaidgroupDto apply(TResRaidgroup tResRaidgroup) {
			TResRaidgroupDto dto = new TResRaidgroupDto();
			if (tResRaidgroup == null)
				return dto;
			dto.setName(tResRaidgroup.getName());
			dto.setRaidLevel(tResRaidgroup.getRaidLevel());
			dto.setStatus(tResRaidgroup.getStatus());
			return dto;

		}
	};

	public static Function<TResRaidgroup, TResRaidgroupDto> detail = new Function<TResRaidgroup, TResRaidgroupDto>() {
		public TResRaidgroupDto apply(TResRaidgroup tResRaidgroup) {
			TResRaidgroupDto dto = new TResRaidgroupDto();
			if (tResRaidgroup == null)
				return dto;

			return dto;
		}
	};

}
