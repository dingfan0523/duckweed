package com.blogs.duckweed.manage.service;

import com.blogs.duckweed.manage.domain.UserAuth;
import com.blogs.duckweed.manage.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAuthService {
    private final UserAuthRepository userAuthRepository;

    @Autowired
    public UserAuthService(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    /**
     * 校验账号
     *
     * @param identifier 用户认证唯一标识
     * @param typeList   认证方式集合
     * @return 用户认证实体
     */
    public UserAuth verityAccount(String identifier, List<String> typeList) {
        return userAuthRepository.findByIdentifierAndIdentityTypeIn(identifier, typeList);
    }
}
