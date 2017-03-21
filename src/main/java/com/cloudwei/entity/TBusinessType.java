package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="T_BUSINESS_TYPE")
public class TBusinessType extends BaseEntity{
	@Column(name="T_BUSINESS_TYPE_NAME")
	private String tBusinessTypeName;
	
	@Column(name="T_BUSINESS_TYPE_DESC")
	private String tBusinessTypeDesc;
	
	@Column(name="T_BUSINESS_TYPE_ORDER")
	private int tBusinessTypeOrder;

	public String gettBusinessTypeName() {
		return tBusinessTypeName;
	}

	public void settBusinessTypeName(String tBusinessTypeName) {
		this.tBusinessTypeName = tBusinessTypeName;
	}

	public String gettBusinessTypeDesc() {
		return tBusinessTypeDesc;
	}

	public void settBusinessTypeDesc(String tBusinessTypeDesc) {
		this.tBusinessTypeDesc = tBusinessTypeDesc;
	}

	public int gettBusinessTypeOrder() {
		return tBusinessTypeOrder;
	}

	public void settBusinessTypeOrder(int tBusinessTypeOrder) {
		this.tBusinessTypeOrder = tBusinessTypeOrder;
	}
	
	
	
}