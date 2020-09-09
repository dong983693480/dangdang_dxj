package com.baizhi.dxj.sevice;

import com.baizhi.dxj.entity.Carousel;
import com.baizhi.dxj.entity.Chapter;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ChapterService {
    List<Chapter> queryChapterAll(Integer page, Integer count,String albumId);
    int countChapter();
    //添加
    String addChapter(Chapter c);
    //修改
    void updateChapter(Chapter c);
    //删除
    void deleteChapter(String id);
    //修改路径
    void upload1Chapter(MultipartFile src, String id, HttpServletRequest request);

    //下载
    public void xiazai(String src, HttpServletRequest request, HttpServletResponse response);

    }
