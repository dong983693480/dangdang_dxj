package com.baizhi.dxj.entity;

import java.util.Date;

public class d_order {
	//uuid
	private String id;
	//订单号
	private String order_number;
	//最新时间
	private Date create_Time; 
	//总价
	private Double total_price;
	//地址表的id
	private String addr_id;
	//用户表的id
	private String user_id;
	@Override
	public String toString() {
		return "d_order [id=" + id + ", order_number=" + order_number
				+ ", ceate_Time=" + create_Time + ", total_price=" + total_price
				+ ", addr_id=" + addr_id + ", user_id=" + user_id + "]";
	}
	public d_order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public d_order(String id, String orde_number, Date ceate_Time,
			Double total_price, String addr_id, String user_id) {
		super();
		this.id = id;
		this.order_number = orde_number;
		this.create_Time = ceate_Time;
		this.total_price = total_price;
		this.addr_id = addr_id;
		this.user_id = user_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrde_number() {
		return order_number;
	}
	public void setOrde_number(String order_number) {
		this.order_number = order_number;
	}
	public Date getCeate_Time() {
		return create_Time;
	}
	public void setCeate_Time(Date ceate_Time) {
		this.create_Time = ceate_Time;
	}
	public Double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}
	public String getAddr_id() {
		return addr_id;
	}
	public void setAddr_id(String addr_id) {
		this.addr_id = addr_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
