package com.baizhi.dxj.serviceImpl;

import com.baizhi.dxj.dao.AlbumMapper;
import com.baizhi.dxj.entity.Album;
import com.baizhi.dxj.entity.Carousel;
import com.baizhi.dxj.sevice.AlbumService;
import com.baizhi.dxj.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumMapper albumMapper;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public List<Album> queryAll2(Integer page, Integer count) {
        List<Album> list = albumMapper.queryAll1(page, count);
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public int count() {
        int i = albumMapper.count1();
        return i;
    }

    @Override
    public String add2(Album c) {
        String uuid = UUIDUtil.getUUID();
        c.setId(uuid);
        c.setPubDate(new Date());
        albumMapper.add1(c);
        return uuid;
    }

    @Override
    public void update2(Album c) {
        if(c.getCoverImg()==""){
            c.setCoverImg(null);
        }
        albumMapper.update1(c);
    }

    @Override
    public void del2(String id) {
        albumMapper.del1(id);

    }

    @Override
    public void upload2(MultipartFile src, String id, HttpServletRequest request) {
        String realPath1 = request.getServletContext().getRealPath("/upload/album");
        //判断文件夹是否存在，不存在则创建
        File file1 = new File(realPath1);
        if(!file1.exists()){
            file1.mkdirs();
        }
        String filename1 = src.getOriginalFilename();
        String newname1=new Date().getTime()+"-"+filename1;
        try {
            src.transferTo(new File(realPath1,newname1));
            //修改轮播图信息
            Album album = new Album();
            album.setId(id);
            album.setCoverImg(newname1);
            System.out.println(album);
            albumMapper.update1(album);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
