package com.share.common;

public enum CommonEnum {
    USER_ROLE_ADMIN("ADMIN"), USER_ROLE_COMMON("COMMON"), USER_ROLE_GUEST("GUEST"),
    UTF_8("UTF-8"), APPLICATION_JSON("application/json");

    CommonEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
