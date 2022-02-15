package com.zhangz1.maildemo.controller;

import com.zhangz1.maildemo.domain.entity.User;
import com.zhangz1.maildemo.service.MailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by zhangz1 on 2022/2/13 17:10
 */
@RestController
public class MailController {

    @Resource
    private MailService mailService;

    @RequestMapping(value = "/sendMail", method = RequestMethod.GET)
    public String send(@RequestParam(value = "receiver") String receiver, HttpServletRequest request) {
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String title = "验证码";
        String text = "您的验证码为" + verifyCode + "，请勿泄露此验证码。\n如非本人操作，请忽略该邮件。\n(这是一封自动发送的邮件，请勿回复）";
        request.getSession().setAttribute("verifyCode", verifyCode);
        request.getSession().setAttribute("email", receiver);
        return mailService.send(receiver, title, text);
    }

    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    @ResponseBody
    public boolean verify(@RequestBody User user, HttpServletRequest request) {
        String email = (String) request.getSession().getAttribute("email");
        String verifyCode = (String) request.getSession().getAttribute("verifyCode");
        Map<String, Object> map = new HashMap<>(16);
        map.put("verifyCode", user.getCode());
        map.put("email", user.getEmail());
        return verifyCode.equals(map.get("verifyCode")) && email.equals(map.get("email"));
    }
}
