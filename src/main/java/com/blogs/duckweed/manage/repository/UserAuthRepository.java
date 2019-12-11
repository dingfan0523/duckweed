package com.blogs.duckweed.manage.repository;

import com.blogs.duckweed.manage.domain.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAuthRepository extends JpaRepository<UserAuth, Integer> {
    public UserAuth findByIdentifierAndIdentityTypeIn(String identifier, List<String> typeList);
}
