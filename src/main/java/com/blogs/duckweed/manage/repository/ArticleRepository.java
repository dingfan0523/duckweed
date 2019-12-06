package com.blogs.duckweed.manage.repository;

import com.blogs.duckweed.manage.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
