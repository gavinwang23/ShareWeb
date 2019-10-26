package com.share.dao.mapper;

import com.share.entity.UsersStation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface UsersStationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UsersStation record);

    int insertSelective(UsersStation record);

    UsersStation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UsersStation record);

    int updateByPrimaryKey(UsersStation record);

    List<UsersStation> getUsersStationByUsername(@Param("userName") String username);

    int updateLoginTimeByUserName(@Param("userName") String username, @Param("loginTime") Date loginTime);
}