package com.cloudwei.dto;


import com.cloudwei.entity.TPatrolProcess;
import com.google.common.base.Function;
/**
 * 查询进程
 */
public class TPatrolProcessDto extends BaseDto {
    public static Function<TPatrolProcess, TPatrolProcessDto> list =
            new Function<TPatrolProcess, TPatrolProcessDto>() {

                @Override
                public TPatrolProcessDto apply(TPatrolProcess TPatrolProcess) {
                    TPatrolProcessDto dto = new TPatrolProcessDto();
                    if (TPatrolProcess == null) {
                        return dto;
                    }
                    dto.setId(TPatrolProcess.getId());
                    dto.setProcessNumber(TPatrolProcess.getProcessNumber());
                    dto.setProcessDescription(TPatrolProcess.getProcessDescription());
                    dto.setPatrolTime(TPatrolProcess.getPatrolTime());                     
                    return dto;
                }
            };

    public static Function<TPatrolProcess, TPatrolProcessDto> detail =
            new Function<TPatrolProcess, TPatrolProcessDto>() {

                @Override
                public TPatrolProcessDto apply(TPatrolProcess TPatrolProcess) {
                    TPatrolProcessDto dto = TPatrolProcessDto.list.apply(TPatrolProcess);
                    if(TPatrolProcess==null){
                        return dto;
                    }
                    dto.setProcessNumber(TPatrolProcess.getProcessNumber());
                    dto.setProcessDescription(TPatrolProcess.getProcessDescription());
                    dto.setProcessStatus(TPatrolProcess.getProcessStatus());
                    dto.setPatrolTime(TPatrolProcess.getPatrolTime());
                    return dto;
                }
        
    };

	private String processNumber;
	private String processDescription;
	private String processStatus;
	private String patrolType;
    private String patrolTime;
    private String serverId;
	public String getProcessNumber() {
		return processNumber;
	}
	public void setProcessNumber(String processNumber) {
		this.processNumber = processNumber;
	}
	public String getProcessDescription() {
		return processDescription;
	}
	public void setProcessDescription(String processDescription) {
		this.processDescription = processDescription;
	}
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
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
