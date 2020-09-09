package com.baizhi.dxj.sevice;

import com.baizhi.dxj.entity.User;

import java.util.HashMap;
import java.util.Map;

public interface Userservice {
    //查所有
    Map<String,Object> queryUserAll(Integer page, Integer rows);

    //修改状态
    void updateUser(User user);
}
