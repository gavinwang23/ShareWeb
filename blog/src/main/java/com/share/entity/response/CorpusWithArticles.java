package com.share.entity.response;

import com.share.entity.dao.ArticleStation;

import java.util.List;

public class CorpusWithArticles {

    private String corpusName;
    private List<String> articles;

    public List<String> getArticles() {
        return articles;
    }

    public void setArticles(List<String> articles) {
        this.articles = articles;
    }

    public String getCorpusName() {
        return corpusName;
    }

    public void setCorpusName(String corpusName) {
        this.corpusName = corpusName;
    }
}
