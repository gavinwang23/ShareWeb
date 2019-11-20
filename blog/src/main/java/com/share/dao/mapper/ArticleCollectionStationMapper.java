package com.share.dao.mapper;

import com.share.entity.dao.ArticleCollectionStation;
import com.share.entity.dao.ArticleStation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ArticleCollectionStationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleCollectionStation record);

    int insertSelective(ArticleCollectionStation record);

    ArticleCollectionStation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleCollectionStation record);

    int updateByPrimaryKeyWithBLOBs(ArticleCollectionStation record);

    int updateByPrimaryKey(ArticleCollectionStation record);

    Integer insertCorpusWithArticles(@Param("corpus") ArticleCollectionStation corpus, @Param("articles") List<ArticleStation> articles);

    Integer deleteCorpusWithNoArticle(@Param("corpus") ArticleCollectionStation corpus);
}