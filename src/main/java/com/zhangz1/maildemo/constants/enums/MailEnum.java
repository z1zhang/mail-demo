package com.zhangz1.maildemo.constants.enums;

/**
 * Created by zhangz1 on 2022/2/16 0:37
 */
public enum MailEnum {
    /**
     * 邮箱枚举常量
     */
    SEND_SUCCESS(200, "发送成功"),
    SEND_FAILURE(300, "发送失败"),
    VERIFY_SUCCESS(200, "验证成功"),
    EMAIL_FAILURE(401, "邮箱错误"),
    CODE_FAILURE(402, "验证码错误");

    private Integer code;
    private String message;

    MailEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

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
}
