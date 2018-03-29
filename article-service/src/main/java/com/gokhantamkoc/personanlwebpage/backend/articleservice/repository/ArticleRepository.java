package com.gokhantamkoc.personanlwebpage.backend.articleservice.repository;

import com.gokhantamkoc.personanlwebpage.backend.articleservice.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ArticleRepository extends JpaRepository<Article, UUID> {
    List<Article> findAllByOrderByCreateDateDesc();
}
