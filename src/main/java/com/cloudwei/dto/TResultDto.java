package com.cloudwei.dto;



import java.util.Date;

import com.cloudwei.entity.TResult;
import com.google.common.base.Function;
/**
 * 节点报表
 */
public class TResultDto extends BaseDto {
    public static Function<TResult, TResultDto> list =
            new Function<TResult, TResultDto>() {

                @Override
                public TResultDto apply(TResult TResult) {
                    TResultDto dto = new TResultDto();
                    if (TResult == null) {
                        return dto;
                    }
                    dto.setId(TResult.getId());
                    dto.setResultTime(TResult.getResultTime());
                    dto.setStatus(TResult.getStatus());
                    dto.setNodeId(TResult.getNodeId());
                    return dto;
                }
            };

	private Date resultTime;
    private String resultOutput;
    private String resultError;
	private String handle;
	private String status;
	private String remark;
	private String nodeId;
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public Date getResultTime() {
		return resultTime;
	}
	public void setResultTime(Date resultTime) {
		this.resultTime = resultTime;
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
	public String getHandle() {
		return handle;
	}
	public void setHandle(String handle) {
		this.handle = handle;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
    

}
