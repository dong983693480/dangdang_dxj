package com.baizhi.dxj.sevice;

import com.baizhi.dxj.entity.Admin;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

public interface AdminService {
    HashMap<String, Object> login(String enCode, String username, String password, HttpSession session);
}
