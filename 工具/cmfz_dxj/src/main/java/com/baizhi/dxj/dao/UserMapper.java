package com.baizhi.dxj.dao;
import com.baizhi.dxj.entity.Album;
import com.baizhi.dxj.entity.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper{
    //查询所有
    List<User> queryUserAll(@Param("page")Integer page, @Param("count")Integer count);
    //总条数
    int countUser();
    //修改
    void updateUser(User c);

}