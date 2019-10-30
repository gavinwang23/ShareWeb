package com.share.dao.mapper;

import com.share.entity.GroupMembersStation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface GroupMembersStationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GroupMembersStation record);

    int insertSelective(GroupMembersStation record);

    GroupMembersStation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GroupMembersStation record);

    int updateByPrimaryKey(GroupMembersStation record);
}