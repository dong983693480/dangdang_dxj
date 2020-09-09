package com.baizhi.dxj.dao;

import java.util.List;

import com.baizhi.dxj.entity.d_item;
import com.baizhi.dxj.entity.d_order;
import com.baizhi.dxj.entity.d_user;
import com.baizhi.dxj.entity.other;
import com.baizhi.dxj.entity.other1;

public interface orderDAO {
	//添加订单表
	public void insertOrder(d_order d);
	//添加订单项表
	public void insertItem(d_item d); 
	
	//查询所有订单
	public List<other> allorder();
	//根据订单号查询订单项
	public List<other1> allorder1(String id);
	//修改用户状态
	public void updateuser(d_user u);
	//查询所有用户
	public List<d_user> allUser();
	//查询单个用户
	public d_user selectone(String id);
}
