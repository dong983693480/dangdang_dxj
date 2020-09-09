package com.baizhi.dxj.entity;

import java.util.Date;

public class d_book {
	private String id;
	private String book_name;//书名*
	private String cate_id;//二级类别的cate_name*
	private Double price;//价格*
	private Double dd_price;//当当价格*
	private String public_count;//库存---*
	private String author;//作者*
	private String company;//出版社*
	private Date publish_time;//出版时间*
	private String edition;//版次*
	private Date print_time;//印刷时间*
	private String print_count;//印刷次数*
	private String isbn;//编号ISBN*
	private String sizes;//开本*
	private String paper;//纸张*
	private String pack;//包装*
	private Integer wordCount;//字数*
	private String pagination;//页数* 
	private String src;//封面路径*
	private String e_recommend;//编辑推荐*
	private String book_description;//内容简介*
	private String aboutTheAuthor;//作者简介*
	private String baseDirectory;//基本目录*
	private String pressReview;//媒体评论*
	private Integer sale_count;//销售数量 ----独立的
	public d_book(String id, String book_name, String cate_id, Double price,
			Double dd_price, String public_count, String author,
			String company, Date publish_time, String edition, Date print_time,
			String print_count, String isbn, String sizes, String paper,
			String pack, Integer wordCount, String pagination, String src,
			String e_recommend, String book_description, String aboutTheAuthor,
			String baseDirectory, String pressReview) {
		super();
		this.id = id;
		this.book_name = book_name;
		this.cate_id = cate_id;
		this.price = price;
		this.dd_price = dd_price;
		this.public_count = public_count;
		this.author = author;
		this.company = company;
		this.publish_time = publish_time;
		this.edition = edition;
		this.print_time = print_time;
		this.print_count = print_count;
		this.isbn = isbn;
		this.sizes = sizes;
		this.paper = paper;
		this.pack = pack;
		this.wordCount = wordCount;
		this.pagination = pagination;
		this.src = src;
		this.e_recommend = e_recommend;
		this.book_description = book_description;
		this.aboutTheAuthor = aboutTheAuthor;
		this.baseDirectory = baseDirectory;
		this.pressReview = pressReview;
	}
	@Override
	public String toString() {
		return "d_book [id=" + id + ", book_name=" + book_name + ", cate_id="
				+ cate_id + ", price=" + price + ", dd_price=" + dd_price
				+ ", public_count=" + public_count + ", author=" + author
				+ ", company=" + company + ", publish_time=" + publish_time
				+ ", edition=" + edition + ", print_time=" + print_time
				+ ", print_count=" + print_count + ", isbn=" + isbn
				+ ", sizes=" + sizes + ", paper=" + paper + ", pack=" + pack
				+ ", wordCount=" + wordCount + ", pagination=" + pagination
				+ ", src=" + src + ", e_recommend=" + e_recommend
				+ ", book_description=" + book_description
				+ ", aboutTheAuthor=" + aboutTheAuthor + ", baseDirectory="
				+ baseDirectory + ", pressReview=" + pressReview
				+ ", sale_count=" + sale_count + "]";
	}
	public d_book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public d_book(String id, String book_name, String cate_id, Double price,
			Double dd_price, String public_count, String author,
			String company, Date publish_time, String edition, Date print_time,
			String print_count, String isbn, String sizes, String paper,
			String pack, Integer wordCount, String pagination, String src,
			String e_recommend, String book_description, String aboutTheAuthor,
			String baseDirectory, String pressReview, Integer sale_count) {
		super();
		this.id = id;
		this.book_name = book_name;
		this.cate_id = cate_id;
		this.price = price;
		this.dd_price = dd_price;
		this.public_count = public_count;
		this.author = author;
		this.company = company;
		this.publish_time = publish_time;
		this.edition = edition;
		this.print_time = print_time;
		this.print_count = print_count;
		this.isbn = isbn;
		this.sizes = sizes;
		this.paper = paper;
		this.pack = pack;
		this.wordCount = wordCount;
		this.pagination = pagination;
		this.src = src;
		this.e_recommend = e_recommend;
		this.book_description = book_description;
		this.aboutTheAuthor = aboutTheAuthor;
		this.baseDirectory = baseDirectory;
		this.pressReview = pressReview;
		this.sale_count = sale_count;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getCate_id() {
		return cate_id;
	}
	public void setCate_id(String cate_id) {
		this.cate_id = cate_id;
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
	public String getPublic_count() {
		return public_count;
	}
	public void setPublic_count(String public_count) {
		this.public_count = public_count;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getPublish_time() {
		return publish_time;
	}
	public void setPublish_time(Date publish_time) {
		this.publish_time = publish_time;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public Date getPrint_time() {
		return print_time;
	}
	public void setPrint_time(Date print_time) {
		this.print_time = print_time;
	}
	public String getPrint_count() {
		return print_count;
	}
	public void setPrint_count(String print_count) {
		this.print_count = print_count;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getSizes() {
		return sizes;
	}
	public void setSizes(String sizes) {
		this.sizes = sizes;
	}
	public String getPaper() {
		return paper;
	}
	public void setPaper(String paper) {
		this.paper = paper;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public Integer getWordCount() {
		return wordCount;
	}
	public void setWordCount(Integer wordCount) {
		this.wordCount = wordCount;
	}
	public String getPagination() {
		return pagination;
	}
	public void setPagination(String pagination) {
		this.pagination = pagination;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getE_recommend() {
		return e_recommend;
	}
	public void setE_recommend(String e_recommend) {
		this.e_recommend = e_recommend;
	}
	public String getBook_description() {
		return book_description;
	}
	public void setBook_description(String book_description) {
		this.book_description = book_description;
	}
	public String getAboutTheAuthor() {
		return aboutTheAuthor;
	}
	public void setAboutTheAuthor(String aboutTheAuthor) {
		this.aboutTheAuthor = aboutTheAuthor;
	}
	public String getBaseDirectory() {
		return baseDirectory;
	}
	public void setBaseDirectory(String baseDirectory) {
		this.baseDirectory = baseDirectory;
	}
	public String getPressReview() {
		return pressReview;
	}
	public void setPressReview(String pressReview) {
		this.pressReview = pressReview;
	}
	public Integer getSale_count() {
		return sale_count;
	}
	public void setSale_count(Integer sale_count) {
		this.sale_count = sale_count;
	}
	
}	