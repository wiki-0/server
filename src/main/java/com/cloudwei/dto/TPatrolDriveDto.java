package com.cloudwei.dto;


import com.cloudwei.entity.TPatrolDrive;
import com.google.common.base.Function;
/**
 * 存储设备 驱动器
 */
public class TPatrolDriveDto extends BaseDto {
    public static Function<TPatrolDrive, TPatrolDriveDto> list =
            new Function<TPatrolDrive, TPatrolDriveDto>() {

                @Override
                public TPatrolDriveDto apply(TPatrolDrive TPatrolDrive) {
                    TPatrolDriveDto dto = new TPatrolDriveDto();
                    if (TPatrolDrive == null) {
                        return dto;
                    }
                    dto.setId(TPatrolDrive.getId());
                    dto.setLibraryName(TPatrolDrive.getLibraryName());
                    dto.setDriveName(TPatrolDrive.getDriveName());
                    dto.setPatrolTime(TPatrolDrive.getPatrolTime());                    
                    return dto;
                }
            };

    public static Function<TPatrolDrive, TPatrolDriveDto> detail =
            new Function<TPatrolDrive, TPatrolDriveDto>() {

                @Override
                public TPatrolDriveDto apply(TPatrolDrive TPatrolDrive) {
                    TPatrolDriveDto dto = TPatrolDriveDto.list.apply(TPatrolDrive);
                    if(TPatrolDrive==null){
                        return dto;
                    }
                    dto.setLibraryName(TPatrolDrive.getLibraryName());
                    dto.setDriveName(TPatrolDrive.getDriveName());
                    dto.setDeviceType(TPatrolDrive.getDeviceType());
                    dto.setOnLine(TPatrolDrive.getOnLine());
                    dto.setPatrolTime(TPatrolDrive.getPatrolTime());
                    return dto;
                }
        
    };

	private String libraryName;
	private String driveName;
	private String deviceType;
	private String onLine;
	private String patrolType;
    private String patrolTime;
    private String serverId;
    
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public String getDriveName() {
		return driveName;
	}
	public void setDriveName(String driveName) {
		this.driveName = driveName;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getOnLine() {
		return onLine;
	}
	public void setOnLine(String onLine) {
		this.onLine = onLine;
	}
	public String getPatrolType() {
		return patrolType;
	}
	public void setPatrolType(String patrolType) {
		this.patrolType = patrolType;
	}
	public String getPatrolTime() {
		return patrolTime;
	}
	public void setPatrolTime(String patrolTime) {
		this.patrolTime = patrolTime;
	}
	public String getServerId() {
		return serverId;
	}
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
    
    

}
