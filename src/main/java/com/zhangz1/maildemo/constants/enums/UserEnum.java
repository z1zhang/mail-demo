package com.zhangz1.maildemo.constants.enums;

/**
 * Created by zhangz1 on 2022/2/16 20:50
 */
public enum UserEnum {
    /**
     *
     */
    SAVE_SUCCESS(200, "注册成功"),
    SAVE_FAILURE(300, "注册失败");
    private Integer status;
    private String message;

    UserEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
