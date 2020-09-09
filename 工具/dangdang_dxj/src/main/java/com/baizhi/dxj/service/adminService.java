package com.baizhi.dxj.service;

import javax.servlet.http.HttpSession;

public interface adminService {
	 String login(String username,String password,String yzm,HttpSession session);
}
