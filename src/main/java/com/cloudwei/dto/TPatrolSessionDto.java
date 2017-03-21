package com.cloudwei.dto;


import com.cloudwei.entity.TPatrolSession;
import com.google.common.base.Function;
/**
 * 会话
 */
public class TPatrolSessionDto extends BaseDto {
    public static Function<TPatrolSession, TPatrolSessionDto> list =
            new Function<TPatrolSession, TPatrolSessionDto>() {

                @Override
                public TPatrolSessionDto apply(TPatrolSession TPatrolSession) {
                    TPatrolSessionDto dto = new TPatrolSessionDto();
                    if (TPatrolSession == null) {
                        return dto;
                    }
                    dto.setId(TPatrolSession.getId());
                    dto.setClientName(TPatrolSession.getClientName());
                    dto.setSessNumber(TPatrolSession.getSessNumber());
                    dto.setPatrolTime(TPatrolSession.getPatrolTime());                      
                    return dto;
                }
            };

    public static Function<TPatrolSession, TPatrolSessionDto> detail =
            new Function<TPatrolSession, TPatrolSessionDto>() {

                @Override
                public TPatrolSessionDto apply(TPatrolSession TPatrolSession) {
                    TPatrolSessionDto dto = TPatrolSessionDto.list.apply(TPatrolSession);
                    if(TPatrolSession==null){
                        return dto;
                    }
                    dto.setClientName(TPatrolSession.getClientName());
                    dto.setSessNumber(TPatrolSession.getSessNumber());
                    dto.setCommMethod(TPatrolSession.getCommMethod());
                    dto.setSessState(TPatrolSession.getSessState());
                    dto.setWaitTime(TPatrolSession.getWaitTime());
                    dto.setBytesSent(TPatrolSession.getBytesSent());
                    dto.setBytesRecvd(TPatrolSession.getBytesRecvd());
                    dto.setSessType(TPatrolSession.getSessType());
                    dto.setPlatform(TPatrolSession.getPlatform());
                    dto.setPatrolTime(TPatrolSession.getPatrolTime());
                    return dto;
                }
        
    };

	private String sessNumber;
	private String commMethod;
	private String sessState;
	private String waitTime;
	private String bytesSent;
	private String bytesRecvd;
	private String sessType;
	private String platform;
	private String clientName;
	private String patrolType;
    private String patrolTime;
    private String serverId;
    
	public String getSessNumber() {
		return sessNumber;
	}
	public void setSessNumber(String sessNumber) {
		this.sessNumber = sessNumber;
	}
	public String getCommMethod() {
		return commMethod;
	}
	public void setCommMethod(String commMethod) {
		this.commMethod = commMethod;
	}
	public String getSessState() {
		return sessState;
	}
	public void setSessState(String sessState) {
		this.sessState = sessState;
	}
	public String getWaitTime() {
		return waitTime;
	}
	public void setWaitTime(String waitTime) {
		this.waitTime = waitTime;
	}
	public String getBytesSent() {
		return bytesSent;
	}
	public void setBytesSent(String bytesSent) {
		this.bytesSent = bytesSent;
	}
	public String getBytesRecvd() {
		return bytesRecvd;
	}
	public void setBytesRecvd(String bytesRecvd) {
		this.bytesRecvd = bytesRecvd;
	}
	public String getSessType() {
		return sessType;
	}
	public void setSessType(String sessType) {
		this.sessType = sessType;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
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
