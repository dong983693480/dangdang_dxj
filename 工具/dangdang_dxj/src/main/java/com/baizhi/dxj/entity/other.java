package com.baizhi.dxj.entity;

import java.util.Date;

public class other {
	//uuid
	private String id;
	//订单号
	private String order_number;
	//总价
	private Double total_price;
	/*//状态
	private String stur;*/
	//收件人
	private String address_name;
	//地址
	private String address_detail;
	
	//最新时间
	private Date create_Time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}

	public Double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}

	public String getAddress_name() {
		return address_name;
	}

	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}

	public String getAddress_detail() {
		return address_detail;
	}

	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}

	public Date getCreate_Time() {
		return create_Time;
	}

	public void setCreate_Time(Date create_Time) {
		this.create_Time = create_Time;
	}

	public other(String id, String order_number, Double total_price,
			String address_name, String address_detail, Date create_Time) {
		super();
		this.id = id;
		this.order_number = order_number;
		this.total_price = total_price;
		this.address_name = address_name;
		this.address_detail = address_detail;
		this.create_Time = create_Time;
	}

	public other() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "other [id=" + id + ", order_number=" + order_number
				+ ", total_price=" + total_price + ", address_name="
				+ address_name + ", address_detail=" + address_detail
				+ ", create_Time=" + create_Time + "]";
	} 
	
}
