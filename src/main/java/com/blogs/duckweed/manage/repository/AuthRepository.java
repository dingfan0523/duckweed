package com.blogs.duckweed.manage.repository;

import com.blogs.duckweed.manage.domain.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthRepository extends JpaRepository<Auth, Integer> {
    @Query(value = "select code from auth where default_flag = 1", nativeQuery = true)
    public List<String> defaultCodeList();
}
