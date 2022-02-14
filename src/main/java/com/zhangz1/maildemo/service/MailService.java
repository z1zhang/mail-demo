package com.zhangz1.maildemo.service;

/**
 * Created by zhang1 on 2022/2/13 17:02
 */
public interface MailService {

    /**
     * 邮件发送
     *
     * @param receiver 接收方
     * @param title    发送的标题
     * @param text     发送的内容
     * @return 发送成功
     */
    String send(String receiver, String title, String text);
}
