package com.baizhi.dxj.entity;

public class other1 {
	private String order_number;
	private Double allprice;
	private String status;
	private String book_name;
	private String src;
	private Double price;
	private Double dd_price;
	private Integer count;
	public String getOrder_number() {
		return order_number;
	}
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	public Double getAllprice() {
		return allprice;
	}
	public void setAllprice(Double allprice) {
		this.allprice = allprice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDd_price() {
		return dd_price;
	}
	public void setDd_price(Double dd_price) {
		this.dd_price = dd_price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public other1(String order_number, Double allprice, String status,
			String book_name, String src, Double price, Double dd_price,
			Integer count) {
		super();
		this.order_number = order_number;
		this.allprice = allprice;
		this.status = status;
		this.book_name = book_name;
		this.src = src;
		this.price = price;
		this.dd_price = dd_price;
		this.count = count;
	}
	public other1() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "other1 [order_number=" + order_number + ", allprice="
				+ allprice + ", status=" + status + ", book_name=" + book_name
				+ ", src=" + src + ", price=" + price + ", dd_price="
				+ dd_price + ", count=" + count + "]";
	}
	
	
}
