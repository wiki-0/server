package com.cloudwei.dto;

import com.cloudwei.entity.TPatrolStgpool;
import com.google.common.base.Function;
/**
 * 存储池
 * @author wiki0
 *
 */
public class TPatrolStgpoolDto extends BaseDto {
    public static Function<TPatrolStgpool, TPatrolStgpoolDto> list =
            new Function<TPatrolStgpool, TPatrolStgpoolDto>() {

                @Override
                public TPatrolStgpoolDto apply(TPatrolStgpool TPatrolStgpool) {
                    TPatrolStgpoolDto dto = new TPatrolStgpoolDto();
                    if (TPatrolStgpool == null) {
                        return dto;
                    }
                    dto.setId(TPatrolStgpool.getId());
                    dto.setStoragePoolName(TPatrolStgpool.getStoragePoolName());
                    dto.setDeviceClassName(TPatrolStgpool.getDeviceClassName());
                    dto.setPatrolTime(TPatrolStgpool.getPatrolTime());                
                    return dto;
                }
            };

    public static Function<TPatrolStgpool, TPatrolStgpoolDto> detail =
            new Function<TPatrolStgpool, TPatrolStgpoolDto>() {

                @Override
                public TPatrolStgpoolDto apply(TPatrolStgpool TPatrolStgpool) {
                    TPatrolStgpoolDto dto = TPatrolStgpoolDto.list.apply(TPatrolStgpool);
                    if(TPatrolStgpool==null){
                        return dto;
                    }
                    dto.setEstimatedCapacity(TPatrolStgpool.getEstimatedCapacity());
                    dto.setPctUtil(TPatrolStgpool.getPctUtil());
                    dto.setPctMigr(TPatrolStgpool.getPctMigr());
                    dto.setHighMigPct(TPatrolStgpool.getHighMigPct());
                    dto.setLowMigPct(TPatrolStgpool.getLowMigPct());
                    dto.setNextStoragePool(TPatrolStgpool.getNextStoragePool());
                    dto.setPatrolTime(TPatrolStgpool.getPatrolTime());
                    return dto;
                }
        
    };

    private String storagePoolName;
	private String deviceClassName;
	private String estimatedCapacity;
	private String pctUtil;
	private String pctMigr;
	private String highMigPct;
	private String lowMigPct;
	private String nextStoragePool;
	private String patrolType;
    private String patrolTime;
    private String serverId;
    
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
	public String getPctMigr() {
		return pctMigr;
	}
	public void setPctMigr(String pctMigr) {
		this.pctMigr = pctMigr;
	}
	public String getHighMigPct() {
		return highMigPct;
	}
	public void setHighMigPct(String highMigPct) {
		this.highMigPct = highMigPct;
	}
	public String getLowMigPct() {
		return lowMigPct;
	}
	public void setLowMigPct(String lowMigPct) {
		this.lowMigPct = lowMigPct;
	}
	public String getNextStoragePool() {
		return nextStoragePool;
	}
	public void setNextStoragePool(String nextStoragePool) {
		this.nextStoragePool = nextStoragePool;
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
