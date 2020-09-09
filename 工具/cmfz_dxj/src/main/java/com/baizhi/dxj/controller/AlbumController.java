package com.baizhi.dxj.controller;


import com.baizhi.dxj.entity.Album;
import com.baizhi.dxj.entity.Carousel;
import com.baizhi.dxj.sevice.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    AlbumService albumService;

    @ResponseBody
    @RequestMapping("/queryAlbumAll")
    public Map<String,Object> queryAlbumAll(Integer page,Integer rows){
        Map<String, Object> maps = new HashMap<String, Object>();
        System.out.println("/////");
        if (page==null) {
            page+=1;
        }
        List<Album> all = albumService.queryAll2(page, rows);
        maps.put("page",page);
        maps.put("rows",all);
        int count1 = albumService.count();
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
    @RequestMapping("/edit")
    @ResponseBody
    public String edit(Album album, String oper ){

        String id=null;

        //添加
        if(oper.equals("add")){
            id= albumService.add2(album);
            System.out.println("--------");
        }
        //修改
        if(oper.equals("edit")){
            albumService.update2(album);
        }

        //删除
        if(oper.equals("del")){
            albumService.del2(album.getId());
        }
        System.out.println("*******");
        return id;
    }


    @RequestMapping("upload1")
    public void upload1(MultipartFile coverImg, String id, HttpServletRequest request){
        albumService.upload2(coverImg, id, request);

    }

}
