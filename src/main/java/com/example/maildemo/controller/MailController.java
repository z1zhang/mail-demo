package com.example.maildemo.controller;

import com.example.maildemo.service.MailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/**
 * Created by zhangz1 on 2022/2/13 17:10
 */
@RestController
public class MailController {


    @Resource
    private MailService mailService;

    @RequestMapping("/sendMail")
    public String send() {
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String sender = "2659445660@qq.com";
        String receiver = "admin@zhangz1.top";
        String title = "验证码";
        String text = "您的验证码为" + checkCode;
        return mailService.send(sender, receiver, title, text);
    }

}
