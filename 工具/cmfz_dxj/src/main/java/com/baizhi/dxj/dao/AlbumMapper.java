package com.baizhi.dxj.dao;

import com.baizhi.dxj.entity.Album;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AlbumMapper {
    //查询所有
    List<Album> queryAll1(@Param("page")Integer page, @Param("count")Integer count);
    //总条数
    int count1();
    //添加
    void add1(Album c);
    //修改
    void update1(Album c);
    //删除
    void del1(String id);

}