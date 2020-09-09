package com.baizhi.dxj.dao;

import com.baizhi.dxj.entity.Carousel;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarouselMapper {
    //查询所有
    List<Carousel> queryAll(@Param("page")Integer page,@Param("count")Integer count);
    //总条数
    int count();
    //添加
    void add(Carousel c);
    //修改
    void update(Carousel c);
    //删除
    void del(String id);
}