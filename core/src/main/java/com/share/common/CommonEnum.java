package com.share.common;

public enum CommonEnum {
    USER_ROLE_ADMIN(0, "ADMIN"), USER_ROLE_COMMON(0, "COMMON"),
    USER_ROLE_GUEST(0, "GUEST"), UTF_8(0, "UTF-8"),
    APPLICATION_JSON(0, "application/json")
    ;

    CommonEnum(Integer code, String name) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private Integer code;

}
