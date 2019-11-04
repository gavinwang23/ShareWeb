package com.share.entity;

import java.io.Serializable;

public class BaseJsonResponse implements Serializable {
    private Integer code;
    private String message;

    public BaseJsonResponse() {
        this.code = 200;
        this.message = "ok";
    }

    public BaseJsonResponse buildFailure(String message) {
        this.code = -1;
        this.message = message;
        return this;
    }

    public BaseJsonResponse buildFailure(Integer code, String message) {
        this.code = code;
        this.message = message;
        return this;
    }

    public BaseJsonResponse buildSuccess(String message) {
        this.code = 200;
        this.message = message;
        return this;
    }

    public BaseJsonResponse buildSuccess(Integer code, String message) {
        this.code = code;
        this.message = message;
        return this;
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

    public BaseJsonResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
