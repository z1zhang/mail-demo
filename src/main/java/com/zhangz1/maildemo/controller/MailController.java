package com.zhangz1.maildemo.controller;

import com.zhangz1.maildemo.domain.entity.User;
import com.zhangz1.maildemo.response.MailResponse;
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
@CrossOrigin
@RestController
public class MailController {

    @Resource
    private MailService mailService;

    @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
    public MailResponse<String> send(@RequestBody User user, HttpServletRequest request) {
        MailResponse<String> mailResponse = new MailResponse<>();
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String title = "验证码";
        String text = "您的验证码为" + verifyCode + "，请勿泄露此验证码。\n如非本人操作，请忽略该邮件。\n(这是一封自动发送的邮件，请勿回复）";
        try {
            System.out.println(user.getCode());
            mailService.send(user.getEmail(), title, text);
        } catch (Exception e) {
            mailResponse.setCode(MailResponse.SEND_FAILURE_CODE);
            mailResponse.setMessage(MailResponse.SEND_FAILURE_MSG);
            return mailResponse;
        }
        request.getSession().setAttribute("verifyCode", verifyCode);
        request.getSession().setAttribute("email", user.getEmail());
        mailResponse.setCode(MailResponse.SEND_SUCCESS_CODE);
        mailResponse.setMessage(MailResponse.SEND_SUCCESS_MSG);
        return mailResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public MailResponse<String> verify(@RequestBody User user, HttpServletRequest request) {
        MailResponse<String> mailResponse = new MailResponse<>();
        String email = (String) request.getSession().getAttribute("email");
        String verifyCode = (String) request.getSession().getAttribute("verifyCode");
        Map<String, Object> map = new HashMap<>(16);
        map.put("verifyCode", user.getCode());
        map.put("email", user.getEmail());
        System.out.println(user.getEmail());
        System.out.println(user.getCode());
        if (verifyCode.equals(map.get("verifyCode")) && email.equals(map.get("email"))) {
            mailResponse.setCode(MailResponse.VERIFY_SUCCESS_CODE);
            mailResponse.setMessage(MailResponse.VERIFY_SUCCESS_MSG);
        }
        if (!verifyCode.equals(map.get("verifyCode"))) {
            mailResponse.setCode(MailResponse.CODE_FAILURE_CODE);
            mailResponse.setMessage(MailResponse.VERIFY_FAILURE_NUM);
        }
        if (!email.equals(map.get("email"))) {
            mailResponse.setCode(MailResponse.EMAIL_FAILURE_CODE);
            mailResponse.setMessage(MailResponse.VERIFY_FAILURE_EMAIL);
        }
        return mailResponse;
    }
}
