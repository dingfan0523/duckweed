package com.blogs.duckweed.manage.repository;

import com.blogs.duckweed.manage.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
