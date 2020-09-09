package com.baizhi.dxj.dao;

import java.util.List;

import com.baizhi.dxj.entity.d_category;

public interface categoryDAO {
	public List<d_category> all();
	//删除
	public void delete(String id);
	//添加一级
	public void selectOne(d_category d);
	//根据名字查询
	public d_category select1(String cate_name);
	//添加二级
	public d_category createej(d_category d);
	//查询所有一级类别
	public List<d_category> select();
}
