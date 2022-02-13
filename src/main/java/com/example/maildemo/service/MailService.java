package com.example.maildemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by zhang1 on 2022/2/13 17:02
 */
@Service

public class MailService {
    final
    JavaMailSender mailSender;
    private final Logger logger = LoggerFactory.getLogger(MailService.class);

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public String send(String sender, String receiver, String title, String text) {
        try {
            //建立邮件消息
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            //发送方
            helper.setFrom(sender);
            //接收方
            helper.setTo(receiver);
            //发送的标题
            helper.setSubject(title);
            //发送的内容
            helper.setText(text);
            mailSender.send(message);
        } catch (MessagingException e) {
            logger.error(e.getMessage());
        }
        return "发送成功";
    }
}
