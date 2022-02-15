package com.zhangz1.maildemo.service.impl;

import com.zhangz1.maildemo.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangz1 on 2022/2/13 22:57
 */
@Service
public class MailServiceImpl implements MailService {

    @Value("${spring.mail.username}")
    private String sender;

    @Resource
    JavaMailSender mailSender;

    private final Logger logger = LoggerFactory.getLogger(MailService.class);

    /**
     * 邮件发送
     *
     * @param receiver 接收方
     * @param title    发送的标题
     * @param text     发送的内容
     */
    @Override
    public void send(String receiver, String title, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(sender);
            message.setTo(receiver);
            message.setSubject(title);
            message.setText(text);
            mailSender.send(message);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
