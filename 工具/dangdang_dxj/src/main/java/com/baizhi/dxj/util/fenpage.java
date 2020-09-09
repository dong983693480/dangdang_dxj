package com.baizhi.dxj.util;

public class fenpage {
	private Integer pageNumber;//页数
	private Integer count;//总条数
	private Integer showCount;//每页展示多少条
	//首条
	public Integer getFirstCount(){
		return (pageNumber-1)*showCount+1;
	}
	//最后一条
	public Integer getEnd(){
		return pageNumber*showCount;
	}
	
	public Integer getPageNumber() {
		return pageNumber;
		
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	//页数
	public Integer getCount() {
		if(count/showCount==0) return count/showCount;
		else return count/showCount;
	}
	public fenpage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public fenpage(Integer pageNumber, Integer count, Integer showCount) {
		super();
		this.pageNumber = pageNumber;
		this.count = count;
		this.showCount = showCount;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getShowCount() {
		return showCount;
	}
	public void setShowCount(Integer showCount) {
		this.showCount = showCount;
	}
}
