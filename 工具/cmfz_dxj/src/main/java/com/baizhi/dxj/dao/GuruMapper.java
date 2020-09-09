package com.baizhi.dxj.dao;

import com.baizhi.dxj.entity.Guru;
import com.baizhi.dxj.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuruMapper {
    //查询所有
    List<Guru> queryGuruAll(@Param("page")Integer page, @Param("count")Integer count);
    //总条数
    int countGuru();
    //修改
    void updateGuru(Guru c);
}