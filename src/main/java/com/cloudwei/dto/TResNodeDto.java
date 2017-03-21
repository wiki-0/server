package com.cloudwei.dto;

import com.cloudwei.entity.TResNode;
import com.google.common.base.Function;

public class TResNodeDto extends BaseDto {
    public static Function<TResNode, TResNodeDto> list =
            new Function<TResNode, TResNodeDto>() {
                @Override
                public TResNodeDto apply(TResNode TResNode) {
                    TResNodeDto dto = new TResNodeDto();
                    if (TResNode == null) {
                        return dto;
                    }
                    dto.setId(TResNode.getId());
                    dto.setIp(TResNode.getIp());
                    return dto;
                }
            };
    private String ip;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
    
}
