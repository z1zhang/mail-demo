package com.zhangz1.maildemo.controller;

import com.zhangz1.maildemo.service.MailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Random;

/**
 * Created by zhangz1 on 2022/2/13 17:10
 */
@RestController
public class MailController {

    @Resource
    private MailService mailService;

    @RequestMapping(value = "/sendMail", method = RequestMethod.GET)
    public String send(@RequestParam(value = "receiver") String receiver) {
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String title = "验证码";
        String text = "您的验证码为" + checkCode + "，请勿泄露此验证码。\n如非本人操作，请忽略该邮件。\n(这是一封自动发送的邮件，请勿回复）";
        return mailService.send(receiver, title, text);
    }

}
