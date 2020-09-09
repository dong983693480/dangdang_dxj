package com.baizhi.dxj.sevice;

import com.baizhi.dxj.entity.Carousel;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CarouselService {
    List<Carousel> queryAll(Integer page,Integer count);
    int count();
    //添加
    String add(Carousel c);
    //修改
    void update(Carousel c);
    //删除
    void del(String id);
    //修改路径
    void upload1(MultipartFile src, String id, HttpServletRequest request);
}
