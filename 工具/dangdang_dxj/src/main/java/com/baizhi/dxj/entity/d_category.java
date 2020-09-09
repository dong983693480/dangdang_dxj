package com.baizhi.dxj.entity;

import java.io.Serializable;
import java.util.List;

public class d_category implements Serializable{
	private String id;
	private String cate_name;
	private Integer count;
	private String parent_id;
	private Integer levels;
	private List<d_category> d;
	@Override
	public String toString() {
		return "d_category [cate_name=" + cate_name + ", count=" + count
				+ ", d=" + d + ", id=" + id + ", levels=" + levels
				+ ", parent_id=" + parent_id + "]";
	}
	public d_category(String id, String cate_name, Integer count,
			String parent_id, Integer levels) {
		super();
		this.id = id;
		this.cate_name = cate_name;
		this.count = count;
		this.parent_id = parent_id;
		this.levels = levels;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public Integer getLevels() {
		return levels;
	}
	public void setLevels(Integer levels) {
		this.levels = levels;
	}
	public List<d_category> getD() {
		return d;
	}
	public void setD(List<d_category> d) {
		this.d = d;
	}
	public d_category(String id, String cate_name, Integer count,
			String parent_id, Integer levels, List<d_category> d) {
		super();
		this.id = id;
		this.cate_name = cate_name;
		this.count = count;
		this.parent_id = parent_id;
		this.levels = levels;
		this.d = d;
	}
	public d_category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
