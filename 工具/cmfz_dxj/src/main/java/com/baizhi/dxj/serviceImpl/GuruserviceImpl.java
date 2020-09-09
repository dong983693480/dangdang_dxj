package com.baizhi.dxj.serviceImpl;

import com.baizhi.dxj.dao.GuruMapper;
import com.baizhi.dxj.entity.Guru;
import com.baizhi.dxj.sevice.Guruservice;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class GuruserviceImpl implements Guruservice {
    @Autowired
    GuruMapper guruMapper;
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Map<String, Object> queryGuruAll(Integer page, Integer rows) {
        Map<String, Object> maps = new HashMap<String, Object>();
        if (page==null) {
            page+=1;
        }
        RowBounds rowBounds = new RowBounds((page-1)*rows,rows);
        List<Guru> all = guruMapper.queryGuruAll(page, rows);
        maps.put("page",page);
        maps.put("rows",all);
        int count1 = guruMapper.countGuru();
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
    public void updateGuru(Guru guru) {
        guruMapper.updateGuru(guru);
    }
}
