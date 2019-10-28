package com.share.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.share.entity.ArticleStation;

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
}