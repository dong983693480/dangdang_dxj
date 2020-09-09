package com.baizhi.dxj.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;

import com.baizhi.dxj.entity.d_address;
import com.baizhi.dxj.entity.d_book;
import com.baizhi.dxj.entity.d_category;
import com.baizhi.dxj.entity.d_user;


public interface userService {
	public String login(String email,String password,HttpSession session);
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
		public List<d_book> selecttwoBook(String pid ,String id);
		//查询
		public d_category selectCategory(String id);
		//查询一级导航栏总条数
		public Integer count1(String id);
		//查询二级导航栏总条数
		public Integer count2(String pid,String id);
		//一级导航栏分页
		public List<d_book> book1(String id,Integer start,Integer end);
		//二级导航栏分页
		public List<d_book> book2(String pid,String id,Integer start,Integer end);
		//注册
		public void addUser(d_user user);
		//查询
		public d_user ddd1(String email);
		//修改状态
		public void update111(d_user user);
		//地址
		public List<d_address> selectaddress(String user_id);
		//添加地址
		public void insertAddress(d_address d);
		//根据地址id查询
		public d_address queryAddressId(String id);
}
