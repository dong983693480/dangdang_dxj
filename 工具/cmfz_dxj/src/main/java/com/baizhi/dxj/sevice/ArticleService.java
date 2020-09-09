package com.baizhi.dxj.sevice;

import com.baizhi.dxj.entity.Article;
import com.baizhi.dxj.entity.User;

import java.util.Map;

public interface ArticleService {
    //查所有
    Map<String,Object> queryArticleAll(Integer page, Integer rows);

    //修改状态
    void updateArticle(Article user);

    void deleteArticle(String id);
}
