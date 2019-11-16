package com.share.entity.dao;

import java.util.Date;

public class FansStation {
    private Long id;

    private String followedUserName;

    private Long followedUserId;

    private String fansUserName;

    private Long fansUserId;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFollowedUserName() {
        return followedUserName;
    }

    public void setFollowedUserName(String followedUserName) {
        this.followedUserName = followedUserName == null ? null : followedUserName.trim();
    }

    public Long getFollowedUserId() {
        return followedUserId;
    }

    public void setFollowedUserId(Long followedUserId) {
        this.followedUserId = followedUserId;
    }

    public String getFansUserName() {
        return fansUserName;
    }

    public void setFansUserName(String fansUserName) {
        this.fansUserName = fansUserName == null ? null : fansUserName.trim();
    }

    public Long getFansUserId() {
        return fansUserId;
    }

    public void setFansUserId(Long fansUserId) {
        this.fansUserId = fansUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}