package com.baizhi.dxj.dao;

import com.baizhi.dxj.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDAO {
    Admin login(@Param("username")String username);

}
