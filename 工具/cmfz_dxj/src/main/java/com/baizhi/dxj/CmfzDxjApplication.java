package com.baizhi.dxj;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@tk.mybatis.spring.annotation.MapperScan("com.baizhi.dxj.dao")
@org.mybatis.spring.annotation.MapperScan("com.baizhi.dxj.dao")
@SpringBootApplication
public class CmfzDxjApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmfzDxjApplication.class, args);
    }

}
