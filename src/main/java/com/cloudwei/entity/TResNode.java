package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="T_NODE")
public class TResNode extends BaseEntity {
	
    @Column(name = "IP")
    private String ip;
    @Column(name = "ROOM_POSITION")
	private String roomPosition;
    
	public String getRoomPosition() {
		return roomPosition;
	}

	public void setRoomPosition(String roomPosition) {
		this.roomPosition = roomPosition;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

    
}
