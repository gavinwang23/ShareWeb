package com.share.dao.mapper;

import com.share.entity.dao.IndexInformationStation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface IndexInformationStationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IndexInformationStation record);

    int insertSelective(IndexInformationStation record);

    IndexInformationStation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IndexInformationStation record);

    int updateByPrimaryKey(IndexInformationStation record);

    List<IndexInformationStation> getIndexInformationListByState(@Param("state") String state);

    void addIndexInformation(@Param("indexList") List<IndexInformationStation> list);
}