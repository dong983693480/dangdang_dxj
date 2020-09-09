package com.baizhi.dxj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.dxj.entity.d_book;
import com.baizhi.dxj.entity.d_category;

public interface bookDAO {
	//查所有
	public List<d_book> selectbookAll();
	//模糊查询
	public List<d_book> mh(@Param("xx")String xx,@Param("name")String name);
	//添加
	public void addbook(d_book d);
	//删除
	public void deleteBook(String id);
	//查询所有的二级类别
	public List<d_category> selectej();
	//修改
	public void updateBook(d_book d);
	//回显
	public d_book selectById(String id);
	//显示二级名
	public d_category look1(String id);
}
