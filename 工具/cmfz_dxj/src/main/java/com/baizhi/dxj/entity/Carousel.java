package com.baizhi.dxj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carousel {
    private String id;

    private String src;

    private String description;

    private String struts;

    private Date createdate;
}