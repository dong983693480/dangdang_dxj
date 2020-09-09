package com.baizhi.dxj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private String id;

    private String title;

    private Date uploadTime;

    private String guruName;

    private String content;

    private String guruId;
    private String img;

}