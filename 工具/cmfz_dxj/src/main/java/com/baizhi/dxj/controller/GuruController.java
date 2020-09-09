package com.baizhi.dxj.controller;

import com.baizhi.dxj.entity.Guru;
import com.baizhi.dxj.entity.User;
import com.baizhi.dxj.sevice.Guruservice;
import com.baizhi.dxj.sevice.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RestController
@RequestMapping("guru")
public class GuruController {

    @Autowired
    Guruservice userservice;

    @RequestMapping("/queryGuruAll")
    public Map<String,Object> queryUserAll(Integer page,Integer rows){
        Map<String, Object> map = userservice.queryGuruAll(page, rows);
        return map;
    }
    @RequestMapping("edit")
    public void edit(Guru user){
        //修改
        userservice.updateGuru(user);


    }
}
