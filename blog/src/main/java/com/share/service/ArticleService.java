package com.share.service;

import com.share.dao.mapper.ArticleStationMapper;
import com.share.entity.dao.ArticleStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleStationMapper articleStationMapper;

    public ArticleStation selectByPrimaryKey(Long id) {
        return articleStationMapper.selectByPrimaryKey(id);
    }

    public int insertSelective(ArticleStation record) {
        return articleStationMapper.insertSelective(record);
    }
}
