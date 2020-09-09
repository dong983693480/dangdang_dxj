package com.baizhi.dxj.dao;

import com.baizhi.dxj.entity.Article;
import com.baizhi.dxj.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper{
    //查询所有
    List<Article> queryArticleAll(@Param("page")Integer page, @Param("count")Integer count);
    //总条数
    int countArticle();
    //添加
    //删除
    void deleteArticle(String id);
    //修改
    void updateArticle(Article c);
}