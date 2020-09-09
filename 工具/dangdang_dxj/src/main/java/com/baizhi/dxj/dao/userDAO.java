package com.baizhi.dxj.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.dxj.entity.d_address;
import com.baizhi.dxj.entity.d_book;
import com.baizhi.dxj.entity.d_category;
import com.baizhi.dxj.entity.d_user;

public interface userDAO {
	//用户登陆
	public d_user loginuser(String email);
	//根据字母推荐排名查询
	public List<d_book> tuijian();
	//根据上架时间进行排序
	public List<d_book> shijian();
	//根据销量进行排序
	public List<d_book> xiaoliang();
	//根据上架时间和销量进行排序
	public List<d_book> xiaoliang1();
	//点击一级菜单
	public List<d_book> selectoneBook(String id);
	//点击二级菜单
	public List<d_book> selecttwoBook(@Param("pid")String pid,@Param("id")String id );
	//查询一级导航栏总条数
	public Integer count1(String id);
	//查询二级导航栏总条数
	public Integer count2(@Param("pid")String pid,@Param("id")String id);
	//一级导航栏分页
	public List<d_book> book1(@Param("id")String id,@Param("star")Integer start,@Param("end")Integer end);
	//二级导航栏分页
	public List<d_book> book2(@Param("pid")String pid,@Param("id")String id,@Param("start")Integer start,@Param("end")Integer end);
	//用户注册
	public void adduser(d_user d);
	//修改状态
	public void update11(d_user d);
	//查询地址
	public List<d_address> selectaddress(String user_id);
	//添加地址
	public void insertAddress(d_address d);
	//根据地址id查询
	public d_address queryAddressId(String id);
}