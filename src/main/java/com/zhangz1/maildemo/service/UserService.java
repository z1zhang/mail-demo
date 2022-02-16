package com.zhangz1.maildemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhangz1.maildemo.domain.entity.User;

/**
 * Created by zhang1 on 2022/2/13 17:02
 */
public interface UserService extends IService<User> {

    /**
     * 邮件发送
     *
     * @param receiver 接收方
     * @param title    发送的标题
     * @param text     发送的内容
     */
    void send(String receiver, String title, String text);

    /**
     * 添加用户
     *
     * @param user user
     * @return Boolean
     */
    @Override
    boolean save(User user);

}
