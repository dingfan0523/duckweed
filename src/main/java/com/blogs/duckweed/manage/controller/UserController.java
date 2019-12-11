package com.blogs.duckweed.manage.controller;

import com.blogs.duckweed.common.domain.BaseResult;
import com.blogs.duckweed.common.util.SHA256Util;
import com.blogs.duckweed.common.util.TokenUtil;
import com.blogs.duckweed.manage.domain.User;
import com.blogs.duckweed.manage.domain.UserAuth;
import com.blogs.duckweed.manage.service.AuthService;
import com.blogs.duckweed.manage.service.UserAuthService;
import com.blogs.duckweed.manage.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dingfan
 */
@Api(description = "用户控制器")
@RestController
@RequestMapping(value = "user")
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

    @ApiOperation(value = "账号密码登录")
    @PostMapping(value = "signIn")
    public BaseResult signIn(@RequestParam("account") @ApiParam("账号") String account,
                             @RequestParam("password") @ApiParam("密码") String password) {
        System.out.println("登录:" + account);
        List<String> codeList = authService.defaultCodeList();
        UserAuth userAuth = userAuthService.verityAccount(account, codeList);
        if (null == userAuth) {
            return BaseResult.failure("账号或密码错误");
        }
        if (!userAuth.getCredential().equals(SHA256Util.encrypt(password))) {
            return BaseResult.failure("账号或密码错误");
        }
        User user = userService.findById(userAuth.getUserId()).orElseThrow(() -> new RuntimeException("登录失败"));
        String token = TokenUtil.createJwtToken(user.getId());
        return BaseResult.success(token);
    }

    @ApiOperation(value = "短信验证码登录")
    @PostMapping(value = "signInSms")
    public BaseResult signInSms(@RequestParam("mobile") @ApiParam("手机号") String mobile,
                                @RequestParam("code") @ApiParam("验证码") String code) {

        return BaseResult.success();
    }

    @ApiOperation(value = "用户实体")
    @GetMapping(value = "list")
    public BaseResult list() {
        return BaseResult.success(userService.findAll());
    }
}
