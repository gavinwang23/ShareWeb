package com.share.entity.response;

import com.share.entity.BaseJsonResponse;
import com.share.entity.dao.ArticleStation;

import java.util.List;

public class ArticleListResponse extends BaseJsonResponse {
    private List<ArticleStation> list;

    public List<ArticleStation> getList() {
        return list;
    }

    public void setList(List<ArticleStation> list) {
        this.list = list;
    }
}
