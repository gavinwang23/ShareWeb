package com.share.dao.mapper;

import com.share.entity.dao.ArticleStation;
import com.share.entity.dao.FavoriteArticlesStation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface FavoriteArticlesStationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FavoriteArticlesStation record);

    int insertSelective(FavoriteArticlesStation record);

    FavoriteArticlesStation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FavoriteArticlesStation record);

    int updateByPrimaryKey(FavoriteArticlesStation record);

    List<ArticleStation> getFavoriteArticlesByUserName(@Param("userName") String userName);
}
