package com.baizhi.dxj.sevice;

import com.baizhi.dxj.entity.Album;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AlbumService {
    List<Album> queryAll2(Integer page, Integer count);
    int count();
    //添加
    String add2(Album c);
    //修改
    void update2(Album c);
    //删除
    void del2(String id);
    //修改路径
    void upload2(MultipartFile src, String id, HttpServletRequest request);
}
