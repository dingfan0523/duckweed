package com.blogs.duckweed.manage.service;

import com.blogs.duckweed.manage.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    private final AuthRepository authRepository;

    @Autowired
    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    /**
     * 默认的认证方式码
     *
     * @return 认证码集合
     */
    public List<String> defaultCodeList() {
        return authRepository.defaultCodeList();
    }
}
