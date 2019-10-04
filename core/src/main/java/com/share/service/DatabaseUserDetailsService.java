package com.share.service;

import com.share.entity.UsersStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("databaseUserDetailService")
public class DatabaseUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersStationService usersStationService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UsersStation> users = usersStationService.getUsersStationByUsername(username);
        if (users == null)
            throw new UsernameNotFoundException("User + " + username + " not found.");
        if (users.size() > 1)
            throw new UsernameNotFoundException("User + " + username + " has too many, please contact our engineer.");

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        UsersStation usersStation = users.get(0);
        grantedAuthorityList.add(new SimpleGrantedAuthority(usersStation.getUserRole()));
        UserDetails userDetails = new User(usersStation.getUserName(), usersStation.getUserPassword(), grantedAuthorityList);

        return userDetails;
    }
}
