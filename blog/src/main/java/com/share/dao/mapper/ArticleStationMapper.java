package com.share.dao.mapper;

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

    List<ArticleStation> getArticleListByUserName(@Param("userName") String userName);

    List<ArticleStation> getArticleListInIndex(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);
}