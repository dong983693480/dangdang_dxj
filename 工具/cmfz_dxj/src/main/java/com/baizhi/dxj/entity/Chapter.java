package com.baizhi.dxj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chapter {
    private String id;

    private String title;

    private String src;

    private String duration;

    private String size;

    private Date uploadTime;

    private String albumId;

}