package com.baizhi.dxj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guru {
    private String id;

    private String name;

    private String picImg;

    private String username;

    private String password;

    private String salt;

    private Date regTime;

}