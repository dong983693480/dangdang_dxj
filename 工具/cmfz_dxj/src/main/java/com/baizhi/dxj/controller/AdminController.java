package com.baizhi.dxj.controller;

import com.baizhi.dxj.entity.Admin;
import com.baizhi.dxj.sevice.AdminService;
import com.baizhi.dxj.util.ImageCodeUtil;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.HashMap;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/x1")
    public void x1(HttpSession session, HttpServletResponse response) throws Exception {

        String securityCode = ImageCodeUtil.getSecurityCode();
        // 将验证码保存至session中
        System.out.println(securityCode);
        session.setAttribute("yzm", securityCode);
        // 生成图片
        BufferedImage createImage = ImageCodeUtil.createImage(securityCode);
        // 将图片以流的形式输出
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(createImage, "png", outputStream);
        outputStream.close();
    }

    @RequestMapping("/login")
    @ResponseBody
    public HashMap login(String username, String password, String yzm1, HttpSession session) throws Exception {

        HashMap<String, Object> map = adminService.login(username, password, yzm1, session);
        return map;

    }
}
