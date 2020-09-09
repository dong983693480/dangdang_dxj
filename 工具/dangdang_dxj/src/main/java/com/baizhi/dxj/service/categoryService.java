package com.baizhi.dxj.service;

import java.util.List;

import com.baizhi.dxj.entity.d_category;

public interface categoryService {
	public List<d_category> all();
	//删除
	public void delect(String id);
	//添加一级分类
	public void selectOne(d_category dd);
	
	public void insertej(d_category dd);
	public List<d_category> cx();
	public d_category zxx(String cate_name);
}
