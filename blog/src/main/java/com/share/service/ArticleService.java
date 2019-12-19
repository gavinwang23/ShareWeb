package com.share.service;

import com.share.dao.mapper.ArticleCollectionStationMapper;
import com.share.dao.mapper.ArticleStationMapper;
import com.share.entity.dao.ArticleCollectionStation;
import com.share.entity.dao.ArticleStation;
import com.share.entity.response.CorpusWithArticles;
import com.share.entity.response.CorpusWithArticlesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public CorpusWithArticlesResponse getCorpusWithArticlesByUserName(String userName) {
        CorpusWithArticlesResponse response = new CorpusWithArticlesResponse();
        List<ArticleCollectionStation> list = articleCollectionStationMapper.getCorpusWithArticlesByUserName(userName);
        if (list == null || list.size() == 0)
            return response;

        List<CorpusWithArticles> corpusWithArticles = new ArrayList<>();
        Map<String, List<ArticleCollectionStation>> map = list.stream().collect(Collectors.groupingBy(ArticleCollectionStation::getCollectionName));
        for (Map.Entry<String, List<ArticleCollectionStation>> entry : map.entrySet()) {
            CorpusWithArticles corpus = new CorpusWithArticles();
            String key = entry.getKey();
            List<ArticleCollectionStation> articleCollectionStationList = entry.getValue();
            List<String> tempList = articleCollectionStationList.stream().map(articleCollectionStation -> articleCollectionStation.getArticleName()).collect(Collectors.toList());
            corpus.setCorpusName(entry.getKey());
            corpus.setArticles(tempList);
            corpusWithArticles.add(corpus);
        }
        response.setCorpus(corpusWithArticles);
        return response;
    }

    public List<ArticleStation> getArticleListInIndex() {
        return getArticleListInIndex(1, 10);
    }

    public List<ArticleStation> getArticleListInIndex(Integer pageNo, Integer pageSize) {
        if (pageNo == null || pageSize == null)
            return articleStationMapper.getArticleListInIndex(0, 10);
        return articleStationMapper.getArticleListInIndex((pageNo - 1) * pageSize, pageSize);
    }

	public List<ArticleStation> getArticlesByUserNameAndCorpusName(String userName, String corpusName) {
		return articleCollectionStationMapper.getArticlesByUserNameAndCorpusName(userName, corpusName);
	}

    public List<ArticleStation> getArticleByUserNameAndArticleTitle(String userName, String articleTitle) {
        return articleStationMapper.getArticleByUserNameAndArticleTitle(userName, articleTitle);
    }

    public List<ArticleStation> getFollowerArticlesByUserName(String userName) {
        return articleStationMapper.getFollowerArticlesByUserName(userName);
    }

}
