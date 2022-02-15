package com.zhangz1.maildemo.response;

/**
 * Created by zhangz1 on 2022/2/15 21:14
 */
public class MailResponse<T> {

    public static final String SEND_SUCCESS_MSG = "发送成功";
    public static final String SEND_FAILURE_MSG = "发送失败";
    public static final Integer SEND_SUCCESS_CODE = 200;
    public static final Integer SEND_FAILURE_CODE = 300;

    public static final String VERIFY_SUCCESS_MSG = "验证成功";
    public static final String VERIFY_FAILURE_EMAIL = "邮箱错误";
    public static final String VERIFY_FAILURE_NUM = "验证码错误";
    public static final Integer VERIFY_SUCCESS_CODE = 200;
    public static final Integer CODE_FAILURE_CODE = 401;
    public static final Integer EMAIL_FAILURE_CODE = 402;
    private Integer code;
    private String message;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
