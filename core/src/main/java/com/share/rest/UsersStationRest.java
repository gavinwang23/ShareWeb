package com.share.rest;

import com.mysql.cj.util.StringUtils;
import com.share.common.CommonEnum;
import com.share.entity.UsersStation;
import com.share.handler.JwtTokenProvider;
import com.share.redis.RedisService;
import com.share.service.UsersStationService;
import com.share.util.VerifyCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.web.header.Header;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/api")
@ResponseBody
public class UsersStationRest {

    private ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    private HttpServletRequest request = attributes.getRequest();
    private HttpServletResponse response = attributes.getResponse();

    @Autowired
    private Md5PasswordEncoder md5PasswordEncoder;

    @Autowired
    private UsersStationService usersStationService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public UsersStation getUsersFromMysql(@PathVariable Long id) {
        return usersStationService.getUsersStationById(id);
    }

    @GetMapping("/is_username_duplicated/{username}")
    public Boolean isUsernameDuplicated(@PathVariable String username) {
        return usersStationService.isUsernameDuplicated(username);
    }

    @PostMapping("sign_up")
    public String userSignUp(UsersStation usersStation, @RequestParam String verifyCode) {
        if (StringUtils.isNullOrEmpty(verifyCode)
                || StringUtils.isNullOrEmpty(redisService.get(request.getLocalAddr()).toString())
                || !verifyCode.equalsIgnoreCase(redisService.get(request.getLocalAddr()).toString())
        )
            throw new RuntimeException(CommonEnum.NO_VERIFY_CODE.getMessage());

        redisService.del(request.getLocalAddr());

        usersStation.setUserPassword(md5PasswordEncoder.encodePassword(usersStation.getUserPassword(), ""));
        usersStation.setUserRegistTime(new Date());
        usersStation.setUserLoginTime(usersStation.getUserRegistTime());
        usersStation.setUserRole(CommonEnum.USER_ROLE_COMMON.getMessage());

        usersStationService.insertNewUsersStation(usersStation);
        return jwtTokenProvider.createJwtTokenWhenSignUp(usersStation);
    }

    @GetMapping("verify_code")
    public void verifyCode() throws IOException {

        Map<String, Object> map = VerifyCodeUtil.generateCodeAndPic();
        redisService.set(request.getLocalAddr(), map.get("code"), 300L);
        response.setHeader(HttpHeaders.PRAGMA, "no-cache");
        response.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache");
        response.setDateHeader(HttpHeaders.EXPIRES, -1);
        response.setContentType("image/jpeg");
        ServletOutputStream servletOutputStream = response.getOutputStream();
        ImageIO.write((RenderedImage) map.get("codePic"), "jpeg", servletOutputStream);
        servletOutputStream.flush();
        servletOutputStream.close();
    }

    @PostMapping("test")
    public void test(){
        throw new RuntimeException("test exception");
    }
}
