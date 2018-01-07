package com.gokhantamkoc.personanlwebpage.backend.service;

import com.gokhantamkoc.personanlwebpage.backend.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> list();
    Article create(Article article);
    Article update(Article article);
}
