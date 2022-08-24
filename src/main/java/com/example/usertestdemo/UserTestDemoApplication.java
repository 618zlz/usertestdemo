package com.example.usertestdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@MapperScan({"com.example.usertestdemo.dao"}) //扫描的mapper

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class UserTestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserTestDemoApplication.class, args);
    }

}
