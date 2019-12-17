package com.share.service;

import com.share.entity.UsersStation;
import com.share.redis.RedisService;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("databaseUserDetailService")
public class DatabaseUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersStationService usersStationService;

    @Autowired
    private RedisService redisService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = getUserDetailsByUsername(username);
        return userDetails;
    }

    public UserDetails getUserDetailsByUsername(String username) {
        List<UsersStation> users = new ArrayList<>();
        try {
            users = usersStationService.getUsersStationByUsername(username);

            if (users == null)
                throw new UsernameNotFoundException("User + " + username + " not found.");
            if (users.size() > 1)
                throw new UsernameNotFoundException("User + " + username + " has too many, please contact our engineer.");

            List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
            UsersStation usersStation = users.get(0);
            grantedAuthorityList.add(new SimpleGrantedAuthority(usersStation.getUserRole()));
            return new User(usersStation.getUserName(), usersStation.getUserPassword(), grantedAuthorityList);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
