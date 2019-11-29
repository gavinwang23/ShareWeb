package com.share.entity.response;

import com.share.entity.dao.ArticleStation;

import java.util.List;

public class CarouselAndArticlesInIndex {
    private List<ArticleStation> carousels;
    private List<ArticleStation> articles;

    public List<ArticleStation> getCarousels() {
        return carousels;
    }

    public void setCarousels(List<ArticleStation> carousels) {
        this.carousels = carousels;
    }

    public List<ArticleStation> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleStation> articles) {
        this.articles = articles;
    }
}
