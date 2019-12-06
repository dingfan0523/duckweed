package com.blogs.duckweed.manage.controller;

import com.blogs.duckweed.common.domain.BaseResult;
import com.blogs.duckweed.manage.service.AuthService;
import com.blogs.duckweed.manage.service.UserAuthService;
import com.blogs.duckweed.manage.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dingfan
 */
@Api(description = "登录注册控制器")
@RestController("user")
public class UserController {
    private final UserService userService;
    private final UserAuthService userAuthService;
    private final AuthService authService;

    @Autowired
    public UserController(UserService userService, UserAuthService userAuthService, AuthService authService) {
        this.userService = userService;
        this.userAuthService = userAuthService;
        this.authService = authService;
    }

    @ApiModelProperty(value = "账号密码登录")
    public BaseResult signIn(@RequestParam("account") @ApiParam("账号") String account,
                             @RequestParam("password") @ApiParam("密码") String password) {
        List<String> codeList = authService.defaultCodeList();
        return BaseResult.success();
    }
}
