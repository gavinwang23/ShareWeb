package com.share.entity.dao;

import java.util.Date;

public class ArticleStation {
    private Long id;

    private String articleTitle;

    private Integer articleAdmire;

    private String userName;

    private Integer articleOppose;

    private Integer articleBrose;

    private Date articlePublishTime;

    private Integer articleIdEdit;

    private Date articleEditTime;

    private Boolean canBeReprint;

    private String reprintUserName;

    private String reprintLink;

    private String articleContent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public Integer getArticleAdmire() {
        return articleAdmire;
    }

    public void setArticleAdmire(Integer articleAdmire) {
        this.articleAdmire = articleAdmire;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getArticleOppose() {
        return articleOppose;
    }

    public void setArticleOppose(Integer articleOppose) {
        this.articleOppose = articleOppose;
    }

    public Integer getArticleBrose() {
        return articleBrose;
    }

    public void setArticleBrose(Integer articleBrose) {
        this.articleBrose = articleBrose;
    }

    public Date getArticlePublishTime() {
        return articlePublishTime;
    }

    public void setArticlePublishTime(Date articlePublishTime) {
        this.articlePublishTime = articlePublishTime;
    }

    public Integer getArticleIdEdit() {
        return articleIdEdit;
    }

    public void setArticleIdEdit(Integer articleIdEdit) {
        this.articleIdEdit = articleIdEdit;
    }

    public Date getArticleEditTime() {
        return articleEditTime;
    }

    public void setArticleEditTime(Date articleEditTime) {
        this.articleEditTime = articleEditTime;
    }

    public Boolean getCanBeReprint() {
        return canBeReprint;
    }

    public void setCanBeReprint(Boolean canBeReprint) {
        this.canBeReprint = canBeReprint;
    }

    public String getReprintUserName() {
        return reprintUserName;
    }

    public void setReprintUserName(String reprintUserName) {
        this.reprintUserName = reprintUserName == null ? null : reprintUserName.trim();
    }

    public String getReprintLink() {
        return reprintLink;
    }

    public void setReprintLink(String reprintLink) {
        this.reprintLink = reprintLink == null ? null : reprintLink.trim();
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }
}