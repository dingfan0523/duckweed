package com.blogs.duckweed.manage.repository;

import com.blogs.duckweed.manage.domain.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepository extends JpaRepository<UserAuth, Integer> {
}
