package com.baizhi.dxj.dao;

import com.baizhi.dxj.entity.Chapter;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChapterMapper {
    //查所有
    List<Chapter> queryChapterAll(@Param("page")Integer page,@Param("count")Integer count,@Param("albumId")String albumId);
    //总条数
    Integer countChapter();
    //添加
    void addChapter(Chapter c);
    //修改
    void updateChapter(Chapter c);
    //删除
    void deleteChapter(String id);
}