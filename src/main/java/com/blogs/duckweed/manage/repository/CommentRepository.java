package com.blogs.duckweed.manage.repository;

import com.blogs.duckweed.manage.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
