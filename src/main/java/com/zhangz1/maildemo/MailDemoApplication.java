package com.zhangz1.maildemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhang
 */
@MapperScan("com.zhangz1.maildemo.mapper")
@SpringBootApplication
public class MailDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MailDemoApplication.class, args);
    }
}