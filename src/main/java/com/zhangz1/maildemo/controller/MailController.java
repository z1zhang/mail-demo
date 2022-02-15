package com.zhangz1.maildemo.controller;

import com.zhangz1.maildemo.constants.enums.MailEnum;
import com.zhangz1.maildemo.domain.entity.User;
import com.zhangz1.maildemo.constants.RestResponse;
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
    public RestResponse<String> send(@RequestBody User user, HttpServletRequest request) {
        RestResponse<String> restResponse = new RestResponse<>();
        String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String title = "验证码";
        String text = "您的验证码为" + verifyCode + "，请勿泄露此验证码。\n如非本人操作，请忽略该邮件。\n(这是一封自动发送的邮件，请勿回复）";
        try {
            mailService.send(user.getEmail(), title, text);
        } catch (Exception e) {
            restResponse.setCode(MailEnum.SEND_FAILURE.getCode());
            restResponse.setMessage(MailEnum.SEND_FAILURE.getMessage());
            return restResponse;
        }
        request.getSession().setAttribute("verifyCode", verifyCode);
        request.getSession().setAttribute("email", user.getEmail());
        restResponse.setCode(MailEnum.SEND_SUCCESS.getCode());
        restResponse.setMessage(MailEnum.SEND_SUCCESS.getMessage());
        return restResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public RestResponse<String> verify(@RequestBody User user, HttpServletRequest request) {
        RestResponse<String> restResponse = new RestResponse<>();
        String email = (String) request.getSession().getAttribute("email");
        String verifyCode = (String) request.getSession().getAttribute("verifyCode");
        Map<String, Object> map = new HashMap<>(16);
        map.put("verifyCode", user.getCode());
        map.put("email", user.getEmail());
        if (verifyCode.equals(map.get("verifyCode")) && email.equals(map.get("email"))) {
            restResponse.setCode(MailEnum.VERIFY_SUCCESS.getCode());
            restResponse.setMessage(MailEnum.VERIFY_SUCCESS.getMessage());
        }
        if (!verifyCode.equals(map.get("verifyCode"))) {
            restResponse.setCode(MailEnum.CODE_FAILURE.getCode());
            restResponse.setMessage(MailEnum.CODE_FAILURE.getMessage());
        }
        if (!email.equals(map.get("email"))) {
            restResponse.setCode(MailEnum.EMAIL_FAILURE.getCode());
            restResponse.setMessage(MailEnum.EMAIL_FAILURE.getMessage());
        }
        return restResponse;
    }
}
