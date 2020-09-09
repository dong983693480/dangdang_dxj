package com.baizhi.dxj.controller;

import com.baizhi.dxj.entity.Article;
import com.baizhi.dxj.entity.User;
import com.baizhi.dxj.sevice.ArticleService;
import com.baizhi.dxj.sevice.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("/queryArticleAll")
    public Map<String,Object> queryArticleAll(Integer page,Integer rows){
        Map<String, Object> map = articleService.queryArticleAll(page, rows);
        return map;
    }
    @RequestMapping("edit")
    public void edit(Article user,String oper){

        //修改
        if(oper.equals("edit")){
            articleService.updateArticle(user);
        }

        //删除
        if(oper.equals("del")){
            articleService.deleteArticle(user.getId());
        }


    }
}
