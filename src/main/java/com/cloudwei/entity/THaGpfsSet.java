package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="T_Ha_Gpfs_Set") 
public class THaGpfsSet extends BaseEntity{
	@Column(name="THaGpfsSet_NAME")
	private String THaGpfsSet_NAME;
	
	/** 主备顺序      <br>
     * 1.小型机 <br>
     * 2.x86 <br> 
     * 3.HA <br> 
     * 4.Gpfs <br>
     */
	@Column(name="THaGpfsSet_TYPE")
	private String tHaGpfsSetType;
	
	@Column(name="THaGpfsSet_DESC")
	private String tHaGpfsSetDesc;
	
	@Column(name="THaGpfsSet_COMMAND")
	private String tHaGpfsSetCommand;
	
	@Column(name="THaGpfsSet_ORDER")
	private int tHaGpfsSetOrder;
	
	@Column(name="THaGpfsSet_SHOW")
	private String tHaGpfsSetShow;

	public String getTHaGpfsSet_NAME() {
		return THaGpfsSet_NAME;
	}

	public void setTHaGpfsSet_NAME(String tHaGpfsSet_NAME) {
		THaGpfsSet_NAME = tHaGpfsSet_NAME;
	}

	public String gettHaGpfsSetType() {
		return tHaGpfsSetType;
	}

	public void settHaGpfsSetType(String tHaGpfsSetType) {
		this.tHaGpfsSetType = tHaGpfsSetType;
	}

	public String gettHaGpfsSetDesc() {
		return tHaGpfsSetDesc;
	}

	public void settHaGpfsSetDesc(String tHaGpfsSetDesc) {
		this.tHaGpfsSetDesc = tHaGpfsSetDesc;
	}

	public String gettHaGpfsSetCommand() {
		return tHaGpfsSetCommand;
	}

	public void settHaGpfsSetCommand(String tHaGpfsSetCommand) {
		this.tHaGpfsSetCommand = tHaGpfsSetCommand;
	}

	public int gettHaGpfsSetOrder() {
		return tHaGpfsSetOrder;
	}

	public void settHaGpfsSetOrder(int tHaGpfsSetOrder) {
		this.tHaGpfsSetOrder = tHaGpfsSetOrder;
	}

	public String gettHaGpfsSetShow() {
		return tHaGpfsSetShow;
	}

	public void settHaGpfsSetShow(String tHaGpfsSetShow) {
		this.tHaGpfsSetShow = tHaGpfsSetShow;
	}
	
	
}
