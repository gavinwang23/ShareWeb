package com.share.dao.mapper;

import com.share.entity.dao.ArticleCollectionStation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

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
}