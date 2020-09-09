package com.baizhi.dxj.entity;

public class d_address {
	private String id;
	private String name;
	private String detail;
	private String zip_code;
	private String phone;
	private String mobile;
	private String user_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public d_address(String id, String name, String detail, String zip_code,
			String phone, String mobile, String user_id) {
		super();
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.zip_code = zip_code;
		this.phone = phone;
		this.mobile = mobile;
		this.user_id = user_id;
	}
	public d_address() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "d_address [id=" + id + ", name=" + name + ", detail=" + detail
				+ ", zip_code=" + zip_code + ", phone=" + phone + ", mobile="
				+ mobile + ", user_id=" + user_id + "]";
	}
	
	
}
