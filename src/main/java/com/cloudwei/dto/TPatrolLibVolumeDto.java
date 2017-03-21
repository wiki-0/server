package com.cloudwei.dto;


import com.cloudwei.entity.TPatrolLibVolume;
import com.google.common.base.Function;
/**
 * 存储设备 库卷
 */
public class TPatrolLibVolumeDto extends BaseDto {
    public static Function<TPatrolLibVolume, TPatrolLibVolumeDto> list =
            new Function<TPatrolLibVolume, TPatrolLibVolumeDto>() {

                @Override
                public TPatrolLibVolumeDto apply(TPatrolLibVolume TPatrolLibVolume) {
                    TPatrolLibVolumeDto dto = new TPatrolLibVolumeDto();
                    if (TPatrolLibVolume == null) {
                        return dto;
                    }
                    dto.setId(TPatrolLibVolume.getId());
                    dto.setLibraryName(TPatrolLibVolume.getLibraryName());
                    dto.setVolumeName(TPatrolLibVolume.getVolumeName());
                    dto.setPatrolTime(TPatrolLibVolume.getPatrolTime());                    
                    return dto;
                }
            };

    public static Function<TPatrolLibVolume, TPatrolLibVolumeDto> detail =
            new Function<TPatrolLibVolume, TPatrolLibVolumeDto>() {

                @Override
                public TPatrolLibVolumeDto apply(TPatrolLibVolume TPatrolLibVolume) {
                    TPatrolLibVolumeDto dto = TPatrolLibVolumeDto.list.apply(TPatrolLibVolume);
                    if(TPatrolLibVolume==null){
                        return dto;
                    }
                    dto.setLibraryName(TPatrolLibVolume.getLibraryName());
                    dto.setVolumeName(TPatrolLibVolume.getVolumeName());
                    dto.setStatus(TPatrolLibVolume.getStatus());
                    dto.setStatus(TPatrolLibVolume.getStatus());
                    dto.setOwner(TPatrolLibVolume.getOwner());
                    dto.setLastUse(TPatrolLibVolume.getLastUse());
                    dto.setHomeElement(TPatrolLibVolume.getHomeElement());
                    dto.setDeviceType(TPatrolLibVolume.getDeviceType());
                    dto.setPatrolTime(TPatrolLibVolume.getPatrolTime());
                    return dto;
                }
        
    };

	private String libraryName;
	private String volumeName;
	private String status;
	private String owner;
	private String lastUse;
	private String homeElement;
	private String deviceType;
	private String patrolType;
    private String patrolTime;
    private String serverId;
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public String getVolumeName() {
		return volumeName;
	}
	public void setVolumeName(String volumeName) {
		this.volumeName = volumeName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getLastUse() {
		return lastUse;
	}
	public void setLastUse(String lastUse) {
		this.lastUse = lastUse;
	}
	public String getHomeElement() {
		return homeElement;
	}
	public void setHomeElement(String homeElement) {
		this.homeElement = homeElement;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
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
