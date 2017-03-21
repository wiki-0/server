package com.cloudwei.dto;


import com.cloudwei.entity.TPatrolVolume;
import com.google.common.base.Function;
/**
 * 卷
 */
public class TPatrolVolumeDto extends BaseDto {
    public static Function<TPatrolVolume, TPatrolVolumeDto> list =
            new Function<TPatrolVolume, TPatrolVolumeDto>() {

                @Override
                public TPatrolVolumeDto apply(TPatrolVolume TPatrolVolume) {
                    TPatrolVolumeDto dto = new TPatrolVolumeDto();
                    if (TPatrolVolume == null) {
                        return dto;
                    }
                    dto.setId(TPatrolVolume.getId());
                    dto.setStoragePoolName(TPatrolVolume.getStoragePoolName());
                    dto.setVolumeName(TPatrolVolume.getVolumeName());
                    dto.setPatrolTime(TPatrolVolume.getPatrolTime());                     
                    return dto;
                }
            };

    public static Function<TPatrolVolume, TPatrolVolumeDto> detail =
            new Function<TPatrolVolume, TPatrolVolumeDto>() {

                @Override
                public TPatrolVolumeDto apply(TPatrolVolume TPatrolVolume) {
                    TPatrolVolumeDto dto = TPatrolVolumeDto.list.apply(TPatrolVolume);
                    if(TPatrolVolume==null){
                        return dto;
                    }
                    dto.setStoragePoolName(TPatrolVolume.getStoragePoolName());
                    dto.setVolumeName(TPatrolVolume.getVolumeName());
                    dto.setDeviceClassName(TPatrolVolume.getDeviceClassName());
                    dto.setEstimatedCapacity(TPatrolVolume.getEstimatedCapacity());
                    dto.setPctUtil(TPatrolVolume.getPctUtil());
                    dto.setVolumeStatus(TPatrolVolume.getVolumeStatus());
                    dto.setPatrolTime(TPatrolVolume.getPatrolTime());
                    return dto;
                }
        
    };

	private String volumeName;
	private String storagePoolName;
	private String deviceClassName;
	private String estimatedCapacity;
	private String pctUtil;
	private String volumeStatus;
	private String patrolType;
    private String patrolTime;
    private String serverId;
	public String getVolumeName() {
		return volumeName;
	}
	public void setVolumeName(String volumeName) {
		this.volumeName = volumeName;
	}
	public String getStoragePoolName() {
		return storagePoolName;
	}
	public void setStoragePoolName(String storagePoolName) {
		this.storagePoolName = storagePoolName;
	}
	public String getDeviceClassName() {
		return deviceClassName;
	}
	public void setDeviceClassName(String deviceClassName) {
		this.deviceClassName = deviceClassName;
	}
	public String getEstimatedCapacity() {
		return estimatedCapacity;
	}
	public void setEstimatedCapacity(String estimatedCapacity) {
		this.estimatedCapacity = estimatedCapacity;
	}
	public String getPctUtil() {
		return pctUtil;
	}
	public void setPctUtil(String pctUtil) {
		this.pctUtil = pctUtil;
	}
	public String getVolumeStatus() {
		return volumeStatus;
	}
	public void setVolumeStatus(String volumeStatus) {
		this.volumeStatus = volumeStatus;
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
