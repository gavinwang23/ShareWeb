package com.share.dao.mapper;

import com.share.entity.dao.FavoriteArticlesStation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface FavoriteArticlesStationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FavoriteArticlesStation record);

    int insertSelective(FavoriteArticlesStation record);

    FavoriteArticlesStation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FavoriteArticlesStation record);

    int updateByPrimaryKey(FavoriteArticlesStation record);
}
