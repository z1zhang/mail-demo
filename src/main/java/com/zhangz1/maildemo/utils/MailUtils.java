package com.zhangz1.maildemo.utils;

/**
 * Created by zhangz1 on 2022/2/15 20:12
 */
public class MailUtils<V> {

    private Integer code;
    private String msg;
    private V data;

    private final static Integer SUCCESS_CODE = 200;
    private final static Integer FAILURE_CODE = 400;
    private final static Integer FAILURE_EMAIL = 401;
    private final static Integer FAILURE_VERIFY = 402;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }
}
