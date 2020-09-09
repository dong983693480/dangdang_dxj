package com.baizhi.dxj.service;

import com.baizhi.dxj.entity.d_book;
import com.baizhi.dxj.entity.d_category;

import java.io.File;
import java.util.List;

public interface

bookService {
	//查所有
	public List<d_book> selectbookAll();
	//模糊查询
	public List<d_book> mh(String xx,String name);
	//添加
	public void addBook(d_book d,File upload,String address);
	//删除
	public void deleteBook(String id);
	//查询所有的二级类别
	public List<d_category> selectej();
	//回显
	public d_book selectById(String id);
	//修改
	public void updateBook(d_book d,File upload,String address);
}
