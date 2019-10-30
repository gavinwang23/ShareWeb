package com.share.entity;

import java.util.Date;

public class UsersGroupsStation {
    private Long id;

    private String groupName;

    private String groupCreateUserName;

    private Long groupMembersStationId;

    private Long groupFileMessageId;

    private Date groupCreateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getGroupCreateUserName() {
        return groupCreateUserName;
    }

    public void setGroupCreateUserName(String groupCreateUserName) {
        this.groupCreateUserName = groupCreateUserName == null ? null : groupCreateUserName.trim();
    }

    public Long getGroupMembersStationId() {
        return groupMembersStationId;
    }

    public void setGroupMembersStationId(Long groupMembersStationId) {
        this.groupMembersStationId = groupMembersStationId;
    }

    public Long getGroupFileMessageId() {
        return groupFileMessageId;
    }

    public void setGroupFileMessageId(Long groupFileMessageId) {
        this.groupFileMessageId = groupFileMessageId;
    }

    public Date getGroupCreateTime() {
        return groupCreateTime;
    }

    public void setGroupCreateTime(Date groupCreateTime) {
        this.groupCreateTime = groupCreateTime;
    }
}