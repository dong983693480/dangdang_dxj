package com.baizhi.dxj.controller;

import com.baizhi.dxj.entity.Album;
import com.baizhi.dxj.entity.User;
import com.baizhi.dxj.sevice.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    Userservice userservice;

    @RequestMapping("/queryUserAll")
    public Map<String,Object> queryUserAll(Integer page,Integer rows){
        Map<String, Object> map = userservice.queryUserAll(page, rows);
        return map;
    }
    @RequestMapping("edit")
    public void edit(User user){
        //修改
        userservice.updateUser(user);


    }
}
