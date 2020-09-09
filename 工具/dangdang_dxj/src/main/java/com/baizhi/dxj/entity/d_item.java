package com.baizhi.dxj.entity;

public class d_item {
	//uuid
	private String id;
	//当当价格
	private Double price;
	//数量
	private Integer count;
	//总价
	private Double amount;
	//书籍的id
	private String book_id;
	//订单的id
	private String order_id;
	@Override
	public String toString() {
		return "d_item [id=" + id + ", price=" + price + ", count=" + count
				+ ", amount=" + amount + ", book_id=" + book_id + ", order_id="
				+ order_id + "]";
	}
	public d_item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public d_item(String id, Double price, Integer count, Double amount,
			String book_id, String order_id) {
		super();
		this.id = id;
		this.price = price;
		this.count = count;
		this.amount = amount;
		this.book_id = book_id;
		this.order_id = order_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
}
