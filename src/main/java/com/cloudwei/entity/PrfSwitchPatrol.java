package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_prf_switch_patrol")
public class PrfSwitchPatrol extends BaseEntity{
	
	@Column(name="TPWP_RECV_KB")
	private long tpwpRecvKb;
	
	@Column(name="TPWP_RECV_PKTS")
	private long tpwpRecvPkts;
	
	@Column(name="TPWP_SEND_KB")
	private long tpwpSendKb;
	
	@Column(name="TPWP_SEND_PKTS")
	private long tpwpSendPkts;
	
	@JoinColumn(name="switchPatrol_id")
	@ManyToOne
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

	public Switch getSwitchPatrol() {
		return switchPatrol;
	}

	public void setSwitchPatrol(Switch switchPatrol) {
		this.switchPatrol = switchPatrol;
	}
	

}
