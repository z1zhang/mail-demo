package com.zhangz1.maildemo.domain.entity;

/**
 * Created by zhangz1 on 2022/2/15 0:37
 */
public class User {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String email;
    private String code;
}
