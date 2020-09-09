package com.baizhi.dxj.entity;

public class cartItem {
	private String id;
	private String dd_id;
	private String book_name;
	private Integer count;
	private Double price;
	private Double dd_price;
	private Double allprice; //一本书的总价
	private Double ddallprice; //当当价
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDd_id() {
		return dd_id;
	}
	public void setDd_id(String dd_id) {
		this.dd_id = dd_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
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
	public Double getAllprice() {
		return allprice;
	}
	public void setAllprice(Double allprice) {
		this.allprice = allprice;
	}
	public Double getDdallprice() {
		return ddallprice;
	}
	public void setDdallprice(Double ddallprice) {
		this.ddallprice = ddallprice;
	}
	public cartItem(String id, String dd_id, String book_name, Integer count,
			Double price, Double dd_price, Double allprice, Double ddallprice) {
		super();
		this.id = id;
		this.dd_id = dd_id;
		this.book_name = book_name;
		this.count = count;
		this.price = price;
		this.dd_price = dd_price;
		this.allprice = allprice;
		this.ddallprice = ddallprice;
	}
	public cartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "cartItem [id=" + id + ", dd_id=" + dd_id + ", book_name="
				+ book_name + ", count=" + count + ", price=" + price
				+ ", dd_price=" + dd_price + ", allprice=" + allprice
				+ ", ddallprice=" + ddallprice + "]";
	}
	
}
