package com.share.dao.mapper;

import com.share.entity.dao.ArticleCollectionStation;
import com.share.entity.dao.ArticleStation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ArticleStationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleStation record);

    int insertSelective(ArticleStation record);

    ArticleStation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleStation record);

    int updateByPrimaryKeyWithBLOBs(ArticleStation record);

    int updateByPrimaryKey(ArticleStation record);

    Integer insertCommentWithArticles(@Param("comment") ArticleStation comment, @Param("articles") List<ArticleStation> articles);

    List<ArticleStation> getArticleListByUserName(@Param("userName") String userName);

    List<ArticleStation> getArticleListInIndex(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

    List<ArticleStation> getArticleByUserNameAndArticleTitle(@Param("userName") String userName, @Param("articleTitle") String articleTitle);

    List<ArticleStation> getFollowerArticlesByUserName(@Param("userName") String userName);

    List<ArticleStation> getCommentsByArticleTitle(@Param("articleTitle") String articleTitle);

}
