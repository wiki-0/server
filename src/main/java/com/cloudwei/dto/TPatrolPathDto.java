package com.cloudwei.dto;

import com.cloudwei.entity.TPatrolPath;
import com.google.common.base.Function;
/**
 * 存储设备 路径
 */
public class TPatrolPathDto extends BaseDto {
    public static Function<TPatrolPath, TPatrolPathDto> list =
            new Function<TPatrolPath, TPatrolPathDto>() {

                @Override
                public TPatrolPathDto apply(TPatrolPath TPatrolPath) {
                    TPatrolPathDto dto = new TPatrolPathDto();
                    if (TPatrolPath == null) {
                        return dto;
                    }
                    dto.setId(TPatrolPath.getId());
                    dto.setSourceName(TPatrolPath.getSourceName());
                    dto.setDestinationName(TPatrolPath.getDestinationName());
                    dto.setPatrolTime(TPatrolPath.getPatrolTime());                      
                    return dto;
                }
            };

    public static Function<TPatrolPath, TPatrolPathDto> detail =
            new Function<TPatrolPath, TPatrolPathDto>() {

                @Override
                public TPatrolPathDto apply(TPatrolPath TPatrolPath) {
                    TPatrolPathDto dto = TPatrolPathDto.list.apply(TPatrolPath);
                    if(TPatrolPath==null){
                        return dto;
                    }
                    dto.setSourceName(TPatrolPath.getSourceName());
                    dto.setDestinationName(TPatrolPath.getDestinationName());
                    dto.setSourceType(TPatrolPath.getSourceType());
                    dto.setDestinationType(TPatrolPath.getDestinationType());
                    dto.setOnLine(TPatrolPath.getOnLine());
                    dto.setPatrolTime(TPatrolPath.getPatrolTime());
                    return dto;
                }
        
    };

	private String sourceName;
	private String sourceType;
	private String destinationName;
	private String destinationType;
	private String onLine;
	private String patrolType;
    private String patrolTime;
    private String serverId;
    
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getSourceType() {
		return sourceType;
	}
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public String getDestinationType() {
		return destinationType;
	}
	public void setDestinationType(String destinationType) {
		this.destinationType = destinationType;
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
