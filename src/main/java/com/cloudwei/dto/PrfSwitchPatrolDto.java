package com.cloudwei.dto;


import com.cloudwei.entity.PrfSwitchPatrol;
import com.cloudwei.entity.Switch;
import com.google.common.base.Function;

public class PrfSwitchPatrolDto extends BaseDto {
	public static Function<PrfSwitchPatrol, PrfSwitchPatrolDto> list = new Function<PrfSwitchPatrol, PrfSwitchPatrolDto>() {
		public PrfSwitchPatrolDto apply(PrfSwitchPatrol prfSwitchPatrol) {
			PrfSwitchPatrolDto dto = new PrfSwitchPatrolDto();
			if (prfSwitchPatrol == null)
				return dto;
			dto.setId(prfSwitchPatrol.getId());
			dto.setTpwpRecvKb(prfSwitchPatrol.getTpwpRecvKb());
            dto.setTpwpRecvPkts(prfSwitchPatrol.getTpwpRecvPkts());
            dto.setTpwpSendKb(prfSwitchPatrol.getTpwpSendKb());
            dto.setTpwpSendPkts(prfSwitchPatrol.getTpwpSendPkts());
			
			return dto;
		}
	};
	private long tpwpRecvKb;
	private long tpwpRecvPkts;
	private long tpwpSendKb;
	private long tpwpSendPkts;
	private String elementName;
	private String ipAddress;
	private Switch switchPatrol;

	public long getTpwpRecvKb() {
		return tpwpRecvKb;
	}

	public void setTpwpRecvKb(long tpwpRecvKb) {
		this.tpwpRecvKb = tpwpRecvKb;
	}

	public long getTpwpRecvPkts() {
		return tpwpRecvPkts;
	}

	public void setTpwpRecvPkts(long tpwpRecvPkts) {
		this.tpwpRecvPkts = tpwpRecvPkts;
	}

	public long getTpwpSendKb() {
		return tpwpSendKb;
	}

	public void setTpwpSendKb(long tpwpSendKb) {
		this.tpwpSendKb = tpwpSendKb;
	}

	public long getTpwpSendPkts() {
		return tpwpSendPkts;
	}

	public void setTpwpSendPkts(long tpwpSendPkts) {
		this.tpwpSendPkts = tpwpSendPkts;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Switch getSwitchPatrol() {
		return switchPatrol;
	}

	public void setSwitchPatrol(Switch switchPatrol) {
		this.switchPatrol = switchPatrol;
	}

}
