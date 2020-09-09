package com.baizhi.dxj.serviceImpl;

import com.baizhi.dxj.dao.AdminDAO;
import com.baizhi.dxj.entity.Admin;
import com.baizhi.dxj.sevice.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDAO adminDAO;
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public HashMap<String, Object> login(String username, String password, String enCode, HttpSession session) {
        HashMap<String, Object> map = new HashMap<>();
        //获取验证码
        String imageCode = (String) session.getAttribute("yzm");
        System.out.println(imageCode+"------"+enCode);
        if(imageCode.equals(enCode)){

            System.out.println("username="+username);


            Admin admin = adminDAO.login(username);
            System.out.println(admin);
            //判断用户
            if(admin!=null){
                if(admin.getPassword().equals(password)){
                    session.setAttribute("admin",admin);
                    map.put("success","200");
                    map.put("message","登录成功");
                }else{
                    map.put("success","400");
                    map.put("message","密码错误");
                }
            }else{
                map.put("success","400");
                map.put("message","该用户不存在");
            }
        }else{
            map.put("success","400");
            map.put("message","验证码不正确");
        }

        return map;
    }
}
