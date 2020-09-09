package com.baizhi.dxj.serviceImpl;

import com.baizhi.dxj.dao.ArticleMapper;
import com.baizhi.dxj.dao.UserMapper;
import com.baizhi.dxj.entity.Article;
import com.baizhi.dxj.entity.User;
import com.baizhi.dxj.sevice.ArticleService;
import com.baizhi.dxj.sevice.Userservice;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Resource
    ArticleMapper articleMapper;
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Map<String, Object> queryArticleAll(Integer page, Integer rows) {
        Map<String, Object> maps = new HashMap<String, Object>();
        if (page==null) {
            page+=1;
        }
        List<Article> all = articleMapper.queryArticleAll(page, rows);
        maps.put("page",page);
        maps.put("rows",all);
        int count1 = articleMapper.countArticle();
        maps.put("records",count1);
        Integer pagecount1 = 0;
        if (count1 % rows == 0) {
            pagecount1 = count1 / rows;
        } else {
            pagecount1 = count1 / rows + 1;
        }
        maps.put("total",pagecount1);
        System.out.println(maps);
        return maps;
    }

    @Override
    public void updateArticle(Article user) {
        articleMapper.updateArticle(user);
    }

    @Override
    public void deleteArticle(String id) {
        articleMapper.deleteArticle(id);
    }
}
