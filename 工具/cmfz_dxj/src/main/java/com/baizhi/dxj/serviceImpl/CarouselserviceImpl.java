package com.baizhi.dxj.serviceImpl;

import com.baizhi.dxj.dao.CarouselMapper;
import com.baizhi.dxj.entity.Carousel;
import com.baizhi.dxj.sevice.CarouselService;
import com.baizhi.dxj.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CarouselserviceImpl implements CarouselService {
    @Autowired
    CarouselMapper carouselMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Carousel> queryAll(Integer page, Integer count) {
        List<Carousel> list = carouselMapper.queryAll(page, count);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int count() {
        int count = carouselMapper.count();
        return count;
    }

    @Override
    public String add(Carousel c) {
        String u=UUIDUtil.getUUID();
        c.setId(u);
        c.setStruts("1");
        c.setCreatedate(new Date());
        carouselMapper.add(c);
        return u;
    }

    @Override
    public void update(Carousel c) {
        if(c.getSrc()==""){
            c.setSrc(null);
        }
        carouselMapper.update(c);
    }

    @Override
    public void del(String id) {
        carouselMapper.del(id);
    }

    @Override
    public void upload1(MultipartFile src, String id, HttpServletRequest request) {
        String realPath = request.getServletContext().getRealPath("/upload");
        //判断文件夹是否存在，不存在则创建
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }
        String filename = src.getOriginalFilename();
        String newname=new Date().getTime()+"-"+filename;
        try {
            src.transferTo(new File(realPath,newname));
            //修改轮播图信息
            Carousel carousel = new Carousel();
            carousel.setId(id);
            carousel.setSrc(newname);
            System.out.println(carousel);
            carouselMapper.update(carousel);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
