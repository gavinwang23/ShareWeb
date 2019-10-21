package com.share.rest;

import com.share.common.CommonEnum;
import com.share.entity.UsersStation;
import com.share.handler.JwtTokenProvider;
import com.share.service.UsersStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
@ResponseBody
public class UsersStationRest {

    @Autowired
    private Md5PasswordEncoder md5PasswordEncoder;

    @Autowired
    private UsersStationService usersStationService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @RequestMapping("/hello")
    public String helloCxfServices() {
        return "Hello world.";
    }

    @RequestMapping("/get/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public UsersStation getUsersFromMysql(@PathVariable Long id) {
        return usersStationService.getUsersStationById(id);
    }

    @PostMapping("sign_up")
    public String userSignUp(UsersStation usersStation) {
        usersStation.setUserPassword(md5PasswordEncoder.encodePassword(usersStation.getUserPassword(), ""));
        usersStation.setUserRegistTime(new Date());
        usersStation.setUserLoginTime(usersStation.getUserRegistTime());
        usersStation.setUserRole(CommonEnum.USER_ROLE_COMMON.getName());

        usersStationService.insertNewUsersStation(usersStation);
        return jwtTokenProvider.createJwtTokenWhenSignUp(usersStation);
    }
}
