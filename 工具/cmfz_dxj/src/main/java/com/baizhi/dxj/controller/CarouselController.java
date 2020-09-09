package com.baizhi.dxj.controller;

import com.baizhi.dxj.entity.Carousel;
import com.baizhi.dxj.sevice.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/carousel")
public class CarouselController {
    @Autowired
    CarouselService carouselService;


    @ResponseBody
    @RequestMapping("/queryAll")
    public Map<String,Object> queryAll(Integer page,Integer rows)throws Exception{
        Map<String, Object> maps = new HashMap<String, Object>();
        if (page==null) {
            page+=1;
        }
        List<Carousel> all = carouselService.queryAll(page, rows);
        maps.put("page",page);
        maps.put("rows",all);
        int count = carouselService.count();
        maps.put("records",count);
        Integer pagecount = 0;
        if (count % rows == 0) {
            pagecount = count / rows;
        } else {
            pagecount = count / rows + 1;
        }
        maps.put("total",pagecount);
        System.out.println(maps);
        return maps;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String edit(Carousel carousel, String oper){

        String id=null;

        //添加
        if(oper.equals("add")){
            id= carouselService.add(carousel);
        }
        //修改
        if(oper.equals("edit")){
          carouselService.update(carousel);
        }

        //删除
        if(oper.equals("del")){
            carouselService.del(carousel.getId());
        }
        return id;
    }


    @RequestMapping("upload1")
    public void uploade1(MultipartFile src, String id, HttpServletRequest request){
        carouselService.upload1(src, id, request);

    }
}
