package com.share.service;

import com.share.dao.mapper.UsersStationMapper;
import com.share.entity.UsersStation;
import com.share.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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

    @Cacheable(value = "users", key = "#username")
    public List<UsersStation> getUsersStationByUsername(String username) {
        List<UsersStation> users = new ArrayList<>();
        users = getUsersStationByUsernameWithTransaction(username);
        return users;
    }

    @Transactional
    public List<UsersStation> getUsersStationByUsernameWithTransaction(String username) {
        List<UsersStation> users = new ArrayList<>();
        users = usersStationMapper.getUsersStationByUsername(username);
        return users;
    }

    public void insertNewUsersStation(UsersStation usersStation) {
        usersStationMapper.insert(usersStation);
    }

    public Boolean isUsernameDuplicated(String username) {
        List<UsersStation> users = getUsersStationByUsername(username);
        return !users.isEmpty();
    }

    public void updateLoginTimeByUserName(String name, Date date) {
        usersStationMapper.updateLoginTimeByUserName(name, date);
    }
}
