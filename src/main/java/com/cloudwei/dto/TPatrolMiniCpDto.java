package com.cloudwei.dto;



import com.cloudwei.entity.Result;
import com.google.common.base.Function;

public class TPatrolMiniCpDto extends BaseDto{
	public static Function<Result, TPatrolMiniCpDto> list=
			new  Function<Result, TPatrolMiniCpDto>(){
		@Override
		public TPatrolMiniCpDto apply(Result result){
			TPatrolMiniCpDto dto=new TPatrolMiniCpDto();
			if(result==null)
				return dto;
			
			dto.setId(result.getId());
			dto.setStatus(result.getStatus());
			dto.setRoomPosition(result.getNode().getRoomPosition());
			dto.setIp(result.getNode().getIp());
			dto.setResultTime(result.getResultTime());
		
			return dto;
		}
	};
	
	public static Function<Result, TPatrolMiniCpDto> detail=
			new  Function<Result, TPatrolMiniCpDto>(){
		@Override
		public TPatrolMiniCpDto apply(Result result){
			TPatrolMiniCpDto dto=TPatrolMiniCpDto.list.apply(result);
			if(result==null)
				return dto;
			
			dto.setResultOutput(result.getResultOutput());	
			dto.setResultError(result.getResultError());
			
		
			return dto;
		}
	};
	
	private String tResNodeSysName;
	private String ip;
	private String roomPosition;
	
	private String resultOutput;
	private String resultError;
	private String resultTime;
	private String status;
	
	
	private String tBusinessTypeName;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getRoomPosition() {
		return roomPosition;
	}
	public void setRoomPosition(String roomPosition) {
		this.roomPosition = roomPosition;
	}
	public String gettBusinessTypeName() {
		return tBusinessTypeName;
	}
	public void settBusinessTypeName(String tBusinessTypeName) {
		this.tBusinessTypeName = tBusinessTypeName;
	}
	
	public String gettResNodeSysName() {
		return tResNodeSysName;
	}
	public void settResNodeSysName(String tResNodeSysName) {
		this.tResNodeSysName = tResNodeSysName;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getResultOutput() {
		return resultOutput;
	}
	public void setResultOutput(String resultOutput) {
		this.resultOutput = resultOutput;
	}
	public String getResultError() {
		return resultError;
	}
	public void setResultError(String resultError) {
		this.resultError = resultError;
	}
	public String getResultTime() {
		return resultTime;
	}
	public void setResultTime(String resultTime) {
		this.resultTime = resultTime;
	}
	
	
}
