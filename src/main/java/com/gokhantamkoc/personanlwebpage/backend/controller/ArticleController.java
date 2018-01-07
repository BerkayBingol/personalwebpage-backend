package com.gokhantamkoc.personanlwebpage.backend.controller;

import com.gokhantamkoc.personanlwebpage.backend.entity.Article;
import com.gokhantamkoc.personanlwebpage.backend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/article")
public class ArticleController extends BaseController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public ResponseEntity<?> list() {
        try {
            return new ResponseEntity<>(articleService.list(), HttpStatus.OK);
        } catch (Exception e) {
            return generateError(e);
        }
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            headers = "Accept=application/json",
            produces = "application/json"
    )
    public ResponseEntity<?> update(@RequestBody Article article, @RequestHeader(value = "token") String token) {
        try {
            return new ResponseEntity<>(articleService.create(article), HttpStatus.OK);
        } catch (Exception e) {
            return generateError(e);
        }
    }

    @RequestMapping(
            method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = "application/json"
    )
    public ResponseEntity<?> create(@RequestBody Article article, @RequestHeader(value = "token") String token) {
        try {
            return new ResponseEntity<>(articleService.update(article), HttpStatus.OK);
        } catch (Exception e) {
            return generateError(e);
        }
    }
}
