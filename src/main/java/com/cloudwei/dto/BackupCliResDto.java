package com.cloudwei.dto;


import java.util.Date;

import com.cloudwei.entity.BackupCliRes;
import com.google.common.base.Function;

public class BackupCliResDto extends BaseDto {
    public static Function<BackupCliRes, BackupCliResDto> list =
            new Function<BackupCliRes, BackupCliResDto>() {
                @Override
                public BackupCliResDto apply(BackupCliRes BackupCliRes) {
                    BackupCliResDto dto = new BackupCliResDto();
                    if (BackupCliRes == null) {
                        return dto;
                    }
                    dto.setId(BackupCliRes.getId());
                    dto.setIp(BackupCliRes.getIp());
                    dto.setPatrolTime(BackupCliRes.getPatrolTime());
                    return dto;
                }
            };
	public static Function<BackupCliRes, BackupCliResDto> detail = new Function<BackupCliRes, BackupCliResDto>() {

		@Override
		public BackupCliResDto apply(BackupCliRes BackupCliRes) {
			BackupCliResDto dto = BackupCliResDto.list.apply(BackupCliRes);
			if (BackupCliRes == null) {
				return dto;
			}
            dto.setId(BackupCliRes.getId());
            dto.setIp(BackupCliRes.getIp());
            dto.setFileDate(BackupCliRes.getFileDate());
            dto.setLocation(BackupCliRes.getLocation());
            dto.setPatrolTime(BackupCliRes.getPatrolTime());
			return dto;
		}

	};

    private Date patrolTime;
    private String patrolType;
    private String ip;
	private String location;
	private String fileDate;
	private String bmResult;
	
	public Date getPatrolTime() {
		return patrolTime;
	}
	public void setPatrolTime(Date patrolTime) {
		this.patrolTime = patrolTime;
	}
	public String getPatrolType() {
		return patrolType;
	}
	public void setPatrolType(String patrolType) {
		this.patrolType = patrolType;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getFileDate() {
		return fileDate;
	}
	public void setFileDate(String fileDate) {
		this.fileDate = fileDate;
	}
	public String getBmResult() {
		return bmResult;
	}
	public void setBmResult(String bmResult) {
		this.bmResult = bmResult;
	}

	

}
