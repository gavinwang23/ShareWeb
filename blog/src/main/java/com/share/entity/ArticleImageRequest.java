package com.share.entity;

import org.springframework.web.multipart.MultipartFile;

public class ArticleImageRequest {
    private String userName;
    private String title;
    private MultipartFile files;

    public ArticleImageRequest() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MultipartFile getFiles() {
        return files;
    }

    public void setFiles(MultipartFile files) {
        this.files = files;
    }
}
