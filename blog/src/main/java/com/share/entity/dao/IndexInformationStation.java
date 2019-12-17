package com.share.entity.dao;

import java.util.Date;

public class IndexInformationStation {
    private Long id;

    private String userName;

    private String indexArticleName;

    private String indexPictureAddress;

    private Date createTime;

    private String state;

    private Long indexArticleId;

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

    public String getIndexArticleName() {
        return indexArticleName;
    }

    public void setIndexArticleName(String indexArticleName) {
        this.indexArticleName = indexArticleName == null ? null : indexArticleName.trim();
    }

    public String getIndexPictureAddress() {
        return indexPictureAddress;
    }

    public void setIndexPictureAddress(String indexPictureAddress) {
        this.indexPictureAddress = indexPictureAddress == null ? null : indexPictureAddress.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Long getIndexArticleId() {
        return indexArticleId;
    }

    public void setIndexArticleId(Long indexArticleId) {
        this.indexArticleId = indexArticleId;
    }
}