package com.share.dao.mapper;

import com.share.entity.dao.FansStation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface FansStationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FansStation record);

    int insertSelective(FansStation record);

    FansStation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FansStation record);

    int updateByPrimaryKey(FansStation record);
}