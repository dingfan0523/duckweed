package com.blogs.duckweed.manage.repository;

import com.blogs.duckweed.manage.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
