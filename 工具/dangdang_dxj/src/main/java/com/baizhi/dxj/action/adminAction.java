package com.baizhi.dxj.action;


import com.baizhi.dxj.entity.admin;
import com.baizhi.dxj.service.adminService;
import com.baizhi.dxj.service.adminServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import javax.swing.text.StyleContext;


public class adminAction {
	private admin a;
	private String yzm;


	public admin getA() {
		return a;
	}

	public void setA(admin a) {
		this.a = a;
	}

	adminService ad = new adminServiceImpl();

	public String login1() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String lo = ad.login(a.getUsername(), a.getPassword(), yzm, session);
		session.setAttribute("zt", lo);
		System.out.println(lo);
		if (lo.equals("cg")) {
			return "ok";
		} else {
			return "no";
		}

	}

	public String exit() {
		HttpSession session= ServletActionContext.getRequest().getSession();
		session.removeAttribute("zt");
		return "exit";
	}

	public String getYzm() {
		return yzm;
	}

	public void setYzm(String yzm) {
		this.yzm = yzm;
	}
}




