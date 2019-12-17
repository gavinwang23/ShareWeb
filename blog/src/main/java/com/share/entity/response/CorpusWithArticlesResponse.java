package com.share.entity.response;

import com.share.entity.BaseJsonResponse;

import java.util.List;

public class CorpusWithArticlesResponse extends BaseJsonResponse {

    private List<CorpusWithArticles> corpus;

    public List<CorpusWithArticles> getCorpus() {
        return corpus;
    }

    public void setCorpus(List<CorpusWithArticles> corpus) {
        this.corpus = corpus;
    }
}
