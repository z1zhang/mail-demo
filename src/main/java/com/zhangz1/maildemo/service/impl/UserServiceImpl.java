package com.zhangz1.maildemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhangz1.maildemo.domain.entity.User;
import com.zhangz1.maildemo.mapper.UserMapper;
import com.zhangz1.maildemo.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Value("${spring.mail.username}")
    private String sender;

    @Resource
    JavaMailSender mailSender;

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

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

    /**
     * 添加用户
     *
     * @param user user
     * @return Boolean
     */
    @Override
    public boolean save(User user) {
        return baseMapper.save(user);
    }
}
