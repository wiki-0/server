package com.cloudwei.dto;

//import java.util.Date;

import com.cloudwei.entity.ResServer;
import com.google.common.base.Function;
/**
 * 服务器列表
 * @author wiki0
 *
 */
public class ResServerDto extends BaseDto {
    public static Function<ResServer, ResServerDto> list =
            new Function<ResServer, ResServerDto>() {
//列表页面数据
                @Override
                public ResServerDto apply(ResServer ResServer) {
                    ResServerDto dto = new ResServerDto();
                    if (ResServer == null) {
                        return dto;
                    }
                    dto.setId(ResServer.getId());
                    dto.setIp(ResServer.getIp());
                    dto.setServerName(ResServer.getServerName());
                    dto.setUserName(ResServer.getUserName());
                    return dto;
                }
            };

	private String sofeware;

	private String serverName;

	private String ip;

	private Integer port;

	private String userName;

	public static Function<ResServer, ResServerDto> getList() {
		return list;
	}

	public static void setList(Function<ResServer, ResServerDto> list) {
		ResServerDto.list = list;
	}

	public String getSofeware() {
		return sofeware;
	}

	public void setSofeware(String sofeware) {
		this.sofeware = sofeware;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

}
