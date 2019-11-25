package com.share.service;

import com.share.dao.mapper.ArticleCollectionStationMapper;
import com.share.dao.mapper.ArticleStationMapper;
import com.share.entity.dao.ArticleCollectionStation;
import com.share.entity.dao.ArticleStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleStationMapper articleStationMapper;

    @Autowired
    private ArticleCollectionStationMapper articleCollectionStationMapper;

    public ArticleStation selectByPrimaryKey(Long id) {
        return articleStationMapper.selectByPrimaryKey(id);
    }

    public int insertSelective(ArticleStation record) {
        return articleStationMapper.insertSelective(record);
    }

    public int insertSelective(ArticleCollectionStation record){
        return articleCollectionStationMapper.insertSelective(record);
    }

    public Integer insertCorpusWithArticles(ArticleCollectionStation corpus, List<ArticleStation> articles) {
        return articleCollectionStationMapper.insertCorpusWithArticles(corpus, articles);
    }

    public Integer deleteCorpusWithNoArticle(ArticleCollectionStation corpus) {
        return articleCollectionStationMapper.deleteCorpusWithNoArticle(corpus);
    }

    public List<ArticleStation> getArticleListByUserName(String userName) {
        return articleStationMapper.getArticleListByUserName(userName);
    }
}
