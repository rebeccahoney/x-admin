package com.lantu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//启动类，用来测试
@SpringBootApplication
@MapperScan("com.lantu.*.mapper")
@MapperScan("com.lantu.sys.service.IUserService")
public class XAdminApplication {

    public static void main(String[] args) {

        SpringApplication.run(XAdminApplication.class, args);
    }

}
