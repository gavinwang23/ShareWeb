package com.share.service;

import com.share.dao.mapper.UsersStationMapper;
import com.share.entity.UsersStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersStationService {

    @Autowired
    private UsersStationMapper usersStationMapper;

    public UsersStation getUsersStationById(Long id) {
        UsersStation usersStation = null;
        try {
            usersStation = usersStationMapper.selectByPrimaryKey(id);
            return usersStation;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<UsersStation> getUsersStationByUsername(String username) {
        List<UsersStation> users = new ArrayList<>();
        try {
            users = usersStationMapper.getUsersStationByUsername(username);
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
