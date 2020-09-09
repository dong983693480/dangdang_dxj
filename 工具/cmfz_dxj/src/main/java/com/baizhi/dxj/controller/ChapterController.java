package com.baizhi.dxj.controller;


import com.baizhi.dxj.entity.Album;
import com.baizhi.dxj.entity.Chapter;
import com.baizhi.dxj.sevice.AlbumService;
import com.baizhi.dxj.sevice.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    ChapterService albumService;

    @ResponseBody
    @RequestMapping("/queryChapterAll")
    public Map<String, Object> queryChapterAll(Integer page, Integer rows, String albumId) {
        System.out.println(albumId + "----------");
        Map<String, Object> maps = new HashMap<String, Object>();
        if (page == null) {
            page += 1;
        }
        List<Chapter> all = albumService.queryChapterAll(page, rows, albumId);
        maps.put("page", page);
        maps.put("rows", all);
        int count1 = albumService.countChapter();
        maps.put("records", count1);
        Integer pagecount1 = 0;
        if (count1 % rows == 0) {
            pagecount1 = count1 / rows;
        } else {
            pagecount1 = count1 / rows + 1;
        }
        maps.put("total", pagecount1);
        System.out.println(maps + "-------chapter--------");
        return maps;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String edit(Chapter chapter, String oper, String albumId) {

        String id = null;

        //添加
        if (oper.equals("add")) {
            chapter.setAlbumId(albumId);
            id = albumService.addChapter(chapter);
        }
        //修改
        if (oper.equals("edit")) {
            albumService.updateChapter(chapter);
        }

        //删除
        if (oper.equals("del")) {
            albumService.deleteChapter(chapter.getId());
        }
        return id;
    }


    @RequestMapping("upload1")
    public void uploade1(MultipartFile src, String id, HttpServletRequest request) {
        albumService.upload1Chapter(src, id, request);

    }

    //下载
    @RequestMapping("xiazai")
    public void xiazai(String src, HttpServletRequest request, HttpServletResponse response){
        albumService.xiazai(src, request, response);
    }
}