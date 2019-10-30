package com.share.dao.mapper;

import com.share.entity.UsersGroupsStation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UsersGroupsStationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UsersGroupsStation record);

    int insertSelective(UsersGroupsStation record);

    UsersGroupsStation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UsersGroupsStation record);

    int updateByPrimaryKey(UsersGroupsStation record);
}