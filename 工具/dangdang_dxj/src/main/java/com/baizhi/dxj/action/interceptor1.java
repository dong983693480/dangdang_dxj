package com.baizhi.dxj.action;


import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class interceptor1 implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = ServletActionContext.getRequest().getSession();
		Boolean xx = (Boolean) session.getAttribute("xxx");
		Object as = session.getAttribute("user");
		System.out.println(xx+"----");
		if(xx==null){
			session.setAttribute("xxx", false);
			return "no";
			
		}else if(as!=null){
			arg0.invoke();
			return null;
		}
		else{
			arg0.invoke();
			return null;
		}
		
	}

}
