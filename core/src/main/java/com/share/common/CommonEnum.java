package com.share.common;

public enum CommonEnum {
    USER_ROLE_ADMIN(0, "ADMIN"), USER_ROLE_COMMON(0, "COMMON"),
    USER_ROLE_GUEST(0, "GUEST"), UTF_8(0, "UTF-8"),
    APPLICATION_JSON(0, "application/json"),


    //一些常用警告
    NO_VERIFY_CODE(-1, "Please input correct verify-code."),
    NO_CORRECT_INPUT(-1, "Please input the correct parameter."),
    SERVER_INTERNAL_ERROR(-1, "Server internal error, please contact our engineer.")
    ;

    CommonEnum(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
    private Integer code;

}
