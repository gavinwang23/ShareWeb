package com.share.rest;

import com.share.entity.UsersStation;
import com.share.service.UsersStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@ResponseBody
public class UsersStationRest {

    @Autowired
    private UsersStationService usersStationService;

    @RequestMapping("/hello")
    public String helloCxfServices() {
        return "Hello world.";
    }

    @RequestMapping("/get/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public UsersStation getUsersFromMysql(@PathVariable Long id) {
        return usersStationService.getUsersStationById(id);
    }
}
