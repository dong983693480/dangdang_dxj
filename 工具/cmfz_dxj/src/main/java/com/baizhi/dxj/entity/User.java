package com.baizhi.dxj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;

    private String phone;

    private String password;

    private String salt;

    private String status;

    private String picImg;

    private String name;

    private String legalName;

    private String sex;

    private String city;

    private String sign;

    private Date regTime;

    private String guruId;

}