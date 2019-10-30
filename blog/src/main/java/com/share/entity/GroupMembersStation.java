package com.share.entity;

public class GroupMembersStation {
    private Long id;

    private String userName;

    private Long usersGroupId;

    private Boolean groupAdmin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Long getUsersGroupId() {
        return usersGroupId;
    }

    public void setUsersGroupId(Long usersGroupId) {
        this.usersGroupId = usersGroupId;
    }

    public Boolean getGroupAdmin() {
        return groupAdmin;
    }

    public void setGroupAdmin(Boolean groupAdmin) {
        this.groupAdmin = groupAdmin;
    }
}