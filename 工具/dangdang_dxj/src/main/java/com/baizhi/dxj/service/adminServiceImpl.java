package com.baizhi.dxj.service;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dxj.dao.adminDAO;
import com.baizhi.dxj.service.adminService;


import com.baizhi.dxj.util.SqlUtil;
import com.baizhi.dxj.entity.admin;



public class adminServiceImpl implements adminService{

	@Override
	public String login(String username, String password, String yzm,HttpSession session) {
		try {
			adminDAO a = (adminDAO) SqlUtil.getMapper(adminDAO.class);
			admin admin = a.login(username);
			String yyy = (String) session.getAttribute("yzm");
			
				if(yyy.equals(yzm)){
					if(admin!=null){
						if (admin.getPassword().equals(password)) {
							session.setAttribute("admin",admin);
							return "cg";
						}else{
							return "密码错误";
						}
					}else{return "账号不存在";}
				}else if(admin==null || yzm.equals(null)){
						return "";
					
				}else{
					return "验证码错误";
				}	
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("adminService");
		}
	}
	
}
