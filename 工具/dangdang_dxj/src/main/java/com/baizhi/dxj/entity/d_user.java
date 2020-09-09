package com.baizhi.dxj.entity;

import java.util.Date;

public class d_user {
	private String id;
	private String nick_name;
	private String email;
	private String password;
	private Integer status;
	private Date regist_time;
	private String salt;
	@Override
	public String toString() {
		return "d_user [id=" + id + ", nick_name=" + nick_name + ", email="
				+ email + ", password=" + password + ", status=" + status
				+ ", regist_time=" + regist_time + ", salt=" + salt + "]";
	}
	public d_user() {
		super();
		// TODO Auto-generated constructor stub
	}
	public d_user(String id, String nick_name, String email, String password,
			Integer status, Date regist_time, String salt) {
		super();
		this.id = id;
		this.nick_name = nick_name;
		this.email = email;
		this.password = password;
		this.status = status;
		this.regist_time = regist_time;
		this.salt = salt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getRegist_time() {
		return regist_time;
	}
	public void setRegist_time(Date regist_time) {
		this.regist_time = regist_time;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
}
