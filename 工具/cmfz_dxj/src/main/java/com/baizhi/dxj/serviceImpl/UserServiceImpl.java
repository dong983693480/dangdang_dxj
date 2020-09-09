package com.baizhi.dxj.serviceImpl;

import com.baizhi.dxj.dao.UserMapper;
import com.baizhi.dxj.entity.Album;
import com.baizhi.dxj.entity.User;
import com.baizhi.dxj.sevice.Userservice;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ognl.DynamicSubscript.all;

@Service
@Transactional
public class UserServiceImpl implements Userservice {
    @Resource
    UserMapper userMapper;
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Map<String, Object> queryUserAll(Integer page, Integer rows) {
        Map<String, Object> maps = new HashMap<String, Object>();
        if (page==null) {
            page+=1;
        }
        RowBounds rowBounds = new RowBounds((page-1)*rows,rows);
        List<User> all = userMapper.queryUserAll(page, rows);
        maps.put("page",page);
        maps.put("rows",all);
        int count1 = userMapper.countUser();
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
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
