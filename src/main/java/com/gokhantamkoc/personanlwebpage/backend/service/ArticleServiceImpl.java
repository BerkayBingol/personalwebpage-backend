package com.gokhantamkoc.personanlwebpage.backend.service;

import com.gokhantamkoc.personanlwebpage.backend.entity.Article;
import com.gokhantamkoc.personanlwebpage.backend.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    ArticleRepository articleRepository;

    @Override
    public List<Article> list() {
        return null;
    }

    @Override
    public Article create(Article article) {
        return null;
    }

    @Override
    public Article update(Article article) {
        return null;
    }
}
