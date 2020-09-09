package com.baizhi.dxj.action;

import com.baizhi.dxj.entity.d_user;
import com.baizhi.dxj.entity.other;
import com.baizhi.dxj.entity.other1;
import com.baizhi.dxj.service.orderService;
import com.baizhi.dxj.service.orderServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.List;


public class orderAction {
	private List<other1> allorder1;
	private String id;
		orderService o=new orderServiceImpl();
	
	public String orderall(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<other> allorder = o.allorder();
		session.setAttribute("allorder", allorder);
		return "orderall";
		
	}
	
	public String itemall(){
		
		allorder1 = o.allorder1(id);
		System.out.println(allorder1+"---");
		return "itemall";
	}
	List<d_user> list;
	public String alluser(){
		list = o.allUser();
		return "alluser";
	}
	
	public String updateUser(){
		d_user user = o.selectone(id);
		if(user.getStatus()==1){
			user.setStatus(2);
			o.updateuser(user);
		}else{
			user.setStatus(1);
			o.updateuser(user);
		}
		return "updateUser";
		
	}

	
	
	
	
	
	
	
	
	
	public List<d_user> getList() {
		return list;
	}

	public void setList(List<d_user> list) {
		this.list = list;
	}

	public List<other1> getAllorder1() {
		return allorder1;
	}

	public void setAllorder1(List<other1> allorder1) {
		this.allorder1 = allorder1;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
