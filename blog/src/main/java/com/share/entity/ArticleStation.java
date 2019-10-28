package com.share.entity;

public class ArticleStation {
    private Long id;

    private String articleTitle;

    private Integer articleAdmire;

    private String userName;

    private Integer articleOppose;

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

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }
}