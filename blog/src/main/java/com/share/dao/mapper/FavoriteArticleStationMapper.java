package com.share.dao.mapper;

import com.share.entity.dao.FavoriteArticleStation;

public interface FavoriteArticleStationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FavoriteArticleStation record);

    int insertSelective(FavoriteArticleStation record);

    FavoriteArticleStation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FavoriteArticleStation record);

    int updateByPrimaryKey(FavoriteArticleStation record);
}
