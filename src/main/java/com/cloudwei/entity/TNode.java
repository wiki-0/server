package com.cloudwei.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_NODE")
public class TNode extends BaseEntity {
	// @Column(name="")
	@Column(name = "ROOM_POSITION")
	private String roomPosition;
	@Column(name = "INTERNAL_NUMBER")
	private String internalNumber;
	@Column(name = "RACK_NUMBER")
	private String rackNumber;
	@Column(name = "LOCATION")
	private String location;
	@Column(name = "VENDOR")
	private String vendor;
	@Column(name = "MODEL")
	private String model;
	@Column(name = "SN")
	private String sn;
	@Column(name = "CONFIG")
	private String config;
	@Column(name = "DEVICE_TYPE")
	private String deviceType;
	@Column(name = "PARTITION_INFO")
	private String partitionType;
	@Column(name = "IP")
	private String ip;
	@Column(name = "OS")
	private String os;
	@Column(name = "BEGIN_DATE")
	private Timestamp beginDate;
	@Column(name = "END_DATE")
	private Timestamp endDate;
	@Column(name = "DEPARTMENT")
	private String deparment;
	@Column(name = "APP_DEPARMENT")
	private String appDeparment;
	@Column(name = "CONTACTS")
	private String contacts;
	@Column(name = "TELEPHONE")
	private String telephone;
	@Column(name = "REMARK")
	private String remark;
	@Column(name = "HOST_NAME")
	private String hostName;
	@Column(name = "CONTROL_IP")
	private String controlIp;
	@Column(name = "CONTROL_USER")
	private String controlUser;
	@Column(name = "CONTROL_PWD")
	private String controlPWD;
	@Column(name = "CONTROL_LOGIN")
	private String controlLogin;
	/**
	 * 是否HA巡检 <br>
	 * <NULL>为 不是 <br>
	 * on为集群Ha巡检 <br>
	 */
	@Column(name = "TResNode_HA")
	private String tResNodeHA;
	/**
	 * 是否Gpfs巡检 <br>
	 * <NULL>为 不 <br>
	 * on为Gpfs巡检 <br>
	 */
	@Column(name = "TResNode_GPFS")
	private String tResNodeGPFS;
	@Column(name = "TResNode_ISMAIN")
	private String tResNodeIsMAain;
	@Column(name = "TResNode_SYSNAME")
	private String tResNodeSysName;
	@Column(name = "ACCOUNT")
	private String account;
	@Column(name = "PWD")
	private String pwd;

	@JoinColumn(name = "SYS_ID")
	@ManyToOne
	private TAppSys appSys;

	@ManyToMany(mappedBy = "nodes", targetEntity = TJob.class)
	public Set<TJob> jobs;

	public String getRoomPosition() {
		return roomPosition;
	}

	public void setRoomPosition(String roomPosition) {
		this.roomPosition = roomPosition;
	}

	public String getInternalNumber() {
		return internalNumber;
	}

	public void setInternalNumber(String internalNumber) {
		this.internalNumber = internalNumber;
	}

	public String getRackNumber() {
		return rackNumber;
	}

	public void setRackNumber(String rackNumber) {
		this.rackNumber = rackNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getPartitionType() {
		return partitionType;
	}

	public void setPartitionType(String partitionType) {
		this.partitionType = partitionType;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public Timestamp getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Timestamp beginDate) {
		this.beginDate = beginDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getDeparment() {
		return deparment;
	}

	public void setDeparment(String deparment) {
		this.deparment = deparment;
	}

	public String getAppDeparment() {
		return appDeparment;
	}

	public void setAppDeparment(String appDeparment) {
		this.appDeparment = appDeparment;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getControlIp() {
		return controlIp;
	}

	public void setControlIp(String controlIp) {
		this.controlIp = controlIp;
	}

	public String getControlUser() {
		return controlUser;
	}

	public void setControlUser(String controlUser) {
		this.controlUser = controlUser;
	}

	public String getControlPWD() {
		return controlPWD;
	}

	public void setControlPWD(String controlPWD) {
		this.controlPWD = controlPWD;
	}

	public String getControlLogin() {
		return controlLogin;
	}

	public void setControlLogin(String controlLogin) {
		this.controlLogin = controlLogin;
	}

	public String gettResNodeHA() {
		return tResNodeHA;
	}

	public void settResNodeHA(String tResNodeHA) {
		this.tResNodeHA = tResNodeHA;
	}

	public String gettResNodeGPFS() {
		return tResNodeGPFS;
	}

	public void settResNodeGPFS(String tResNodeGPFS) {
		this.tResNodeGPFS = tResNodeGPFS;
	}

	public String gettResNodeIsMAain() {
		return tResNodeIsMAain;
	}

	public void settResNodeIsMAain(String tResNodeIsMAain) {
		this.tResNodeIsMAain = tResNodeIsMAain;
	}

	public String gettResNodeSysName() {
		return tResNodeSysName;
	}

	public void settResNodeSysName(String tResNodeSysName) {
		this.tResNodeSysName = tResNodeSysName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public TAppSys getAppSys() {
		return appSys;
	}

	public void setAppSys(TAppSys appSys) {
		this.appSys = appSys;
	}

	public Set<TJob> getJobs() {
		return jobs;
	}

	public void setJobs(Set<TJob> jobs) {
		this.jobs = jobs;
	}

}
