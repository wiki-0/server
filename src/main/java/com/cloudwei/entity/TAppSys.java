package com.cloudwei.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_APP_SYS")
public class TAppSys extends BaseEntity{

	@Column(name="NAME")
	private String name;
	@Column(name="T_APPSYS_TYPE")
	private String appSysType;
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="USER1")
	public User user1;
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="USER2")
	public User user2;
	@OneToMany(mappedBy = "appSys", targetEntity = TNode.class,cascade={CascadeType.ALL},orphanRemoval=true)
	public Set<TNode> nodes;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAppSysType() {
		return appSysType;
	}
	public void setAppSysType(String appSysType) {
		this.appSysType = appSysType;
	}
	
	public User getUser1() {
		return user1;
	}
	public void setUser1(User user1) {
		this.user1 = user1;
	}
	public User getUser2() {
		return user2;
	}
	public void setUser2(User user2) {
		this.user2 = user2;
	}
	public Set<TNode> getNodes() {
		return nodes;
	}
	public void setNodes(Set<TNode> nodes) {
		this.nodes = nodes;
	}

	
	
}
