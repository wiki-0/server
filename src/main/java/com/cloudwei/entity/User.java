package com.cloudwei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "t_user",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"USER_NAME", "PERMISSION"})})
public class User extends BaseEntity {

    /** 用户账号 */
    @Column(name = "USER_NAME")
    private String userName;
    /** 密码 */
    private String password;
    /** 显示名称 */
    @Column(name = "DISPLAY_NAME")
    private String displayName;
    /** 部门 */
    private String department;
    /** 手机 */
    @Column(name = "TELPHONE")
    private String telephone;
    /** 邮箱 */
    private String email;
    /** 权限 */
    private String permission;
    /** app用户标识 */
    private String cid;
    /** 用户令牌 */
    private String token;

    public User() {
    }

    public User(User user) {
        super();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.displayName = user.getDisplayName();
        this.department = user.getDepartment();
        this.telephone = user.getTelephone();
        this.email = user.getEmail();
        this.permission = user.getPermission();
        this.cid = user.getCid();
        this.token = user.getToken();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
