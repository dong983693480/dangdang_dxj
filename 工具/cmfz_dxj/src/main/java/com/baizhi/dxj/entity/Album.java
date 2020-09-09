package com.baizhi.dxj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    private String id;

    private String title;
    @Column(name="cover_img")
    private String coverImg;

    private String score;

    private String author;

    private String broadcast;

    private Integer count;

    private String content;
    @Column(name="pub_date")
    private Date pubDate;

}