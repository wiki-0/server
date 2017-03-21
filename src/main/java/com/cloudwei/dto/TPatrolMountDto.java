package com.cloudwei.dto;


import com.cloudwei.entity.TPatrolMount;
import com.google.common.base.Function;
/**
 * 已安装存储信息
 */
public class TPatrolMountDto extends BaseDto {
    public static Function<TPatrolMount, TPatrolMountDto> list =
            new Function<TPatrolMount, TPatrolMountDto>() {

                @Override
                public TPatrolMountDto apply(TPatrolMount TPatrolMount) {
                    TPatrolMountDto dto = new TPatrolMountDto();
                    if (TPatrolMount == null) {
                        return dto;
                    }
                    dto.setId(TPatrolMount.getId());
                    dto.setInfo(TPatrolMount.getInfo());
                    dto.setPatrolTime(TPatrolMount.getPatrolTime());
                    return dto;
                }
            };

    private String info;
    private String patrolType;
    private String patrolTime;
    private String serverId;
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
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
