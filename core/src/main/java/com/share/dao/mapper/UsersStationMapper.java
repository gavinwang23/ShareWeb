package com.share.dao.mapper;

import com.share.entity.UsersStation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersStationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UsersStation record);

    int insertSelective(UsersStation record);

    UsersStation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UsersStation record);

    int updateByPrimaryKey(UsersStation record);

    List<UsersStation> getUsersStationByUsername(String username);
}