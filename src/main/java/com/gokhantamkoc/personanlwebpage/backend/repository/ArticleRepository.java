package com.gokhantamkoc.personanlwebpage.backend.repository;

import com.gokhantamkoc.personanlwebpage.backend.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArticleRepository extends JpaRepository<Article, UUID> {
}
