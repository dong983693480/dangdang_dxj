package com.baizhi.dxj.sevice;

import com.baizhi.dxj.entity.Guru;
import com.baizhi.dxj.entity.User;

import java.util.Map;

public interface Guruservice {
    //查所有
    Map<String,Object> queryGuruAll(Integer page, Integer rows);

    //修改状态
    void updateGuru(Guru guru);
}
