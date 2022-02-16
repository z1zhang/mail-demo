package com.zhangz1.maildemo.constants;

/**
 * 响应类
 * Created by zhangz1 on 2022/2/15 21:14
 */
public class RestResponse<T> {

    private Integer status;
    private String message;
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
