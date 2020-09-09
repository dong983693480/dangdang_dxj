package com.baizhi.dxj.action;

import com.baizhi.dxj.entity.d_category;
import com.baizhi.dxj.service.categoryService;
import com.baizhi.dxj.service.categoryServiceImpl;

import java.util.List;
import java.util.UUID;


public class categoryAction {
	private categoryService ss = new categoryServiceImpl();
	private List<d_category> all;
	private String id;
	private d_category c;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<d_category> getAll() {
		return all;
	}

	public void setAll(List<d_category> all) {
		this.all = all;
	}

	public String selectall(){
		all = ss.all();
		return "all";
	}
	public d_category getC() {
		return c;
	}

	public void setC(d_category c) {
		this.c = c;
	}

	public String delete1(){
		ss.delect(id);
		return "sc";
	}
	public String insertOne(){
		String tt = UUID.randomUUID().toString();
		d_category xx=new d_category(tt,c.getCate_name(),0,"0",1,null);
		ss.selectOne(xx);
		return "tj1";
				
	}
	public String asd(){
		all = ss.cx();
		return "fff";
	}
	private String de;
	public String getDe() {
		return de;
	}

	public void setDe(String de) {
		this.de = de;
	}

	//添加二级类别
	public String Tjej(){
		System.out.println("-------------");
		System.out.println(ss.zxx(de)+"------");
		String sss = UUID.randomUUID().toString();
		d_category x=new d_category(sss,c.getCate_name(),0,ss.zxx(de).getId(),2);
		
		System.out.println(x+"------------------------");
		ss.insertej(x);
		return "tjej";
	}
}
