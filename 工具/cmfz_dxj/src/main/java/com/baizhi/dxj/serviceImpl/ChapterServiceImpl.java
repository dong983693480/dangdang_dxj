package com.baizhi.dxj.serviceImpl;

import com.baizhi.dxj.dao.ChapterMapper;
import com.baizhi.dxj.entity.Carousel;
import com.baizhi.dxj.entity.Chapter;
import com.baizhi.dxj.sevice.ChapterService;
import com.baizhi.dxj.util.UUIDUtil;
import org.apache.commons.io.IOUtils;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    ChapterMapper chapterMapper;



    @Override
    public List<Chapter> queryChapterAll(Integer page, Integer count,String albumId) {
        List<Chapter> list = chapterMapper.queryChapterAll(page, count,albumId);
        return list;
    }

    @Override
    public int countChapter() {
        Integer i = chapterMapper.countChapter();
        return i;
    }

    @Override
    public String addChapter(Chapter c) {
        String uuid = UUIDUtil.getUUID();
        c.setId(uuid);
        c.setUploadTime(new Date());
        chapterMapper.addChapter(c);
        return uuid;
    }

    @Override
    public void updateChapter(Chapter c) {
        if(c.getSrc()==""){
            c.setSrc(null);
        }
        chapterMapper.updateChapter(c);

    }

    @Override
    public void deleteChapter(String id) {
        chapterMapper.deleteChapter(id);

    }

    @Override
    public void upload1Chapter(MultipartFile src, String id, HttpServletRequest request) {
        String realPath = request.getServletContext().getRealPath("/upload/chapter");
        //判断文件夹是否存在，不存在则创建
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }
        String filename = src.getOriginalFilename();
        String newname=new Date().getTime()+"-"+filename;
        try {
            src.transferTo(new File(realPath,newname));

            //获取音频大小    zijie
            long size = src.getSize();
            DecimalFormat format = new DecimalFormat("0.00");
            String str = String.valueOf(size);
            Double dd = Double.valueOf(str)/1024/1024;
            String sizess = format.format(dd)+"MB";



            //获取文件时长   分
            AudioFile audioFile = AudioFileIO.read(new File(realPath, newname));
            AudioHeader audioHeader = audioFile.getAudioHeader();
            int length = audioHeader.getTrackLength();
            String duration=length/60+"分"+length%60+"秒";
            Chapter chapter = new Chapter();
            chapter.setId(id);
            chapter.setSrc(newname);
            chapter.setSize(sizess);
            chapter.setDuration(duration);
            System.out.println(chapter);
            chapterMapper.updateChapter(chapter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xiazai(String src, HttpServletRequest request, HttpServletResponse response) {
        //1.根据相对路径获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload/chapter");

        try {
            //2.创建读入流
            FileInputStream inputStream = new FileInputStream(new File(realPath,src));

            //3.设置响应头   attachment:以附件的形式下载    inline:在线打开
            response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode(src,"UTF-8"));

            //4.文件下载
            IOUtils.copy(inputStream,response.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
