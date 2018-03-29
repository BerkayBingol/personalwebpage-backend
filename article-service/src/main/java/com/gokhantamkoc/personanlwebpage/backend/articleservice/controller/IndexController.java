package com.gokhantamkoc.personanlwebpage.backend.articleservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
<<<<<<< HEAD:src/main/java/com/gokhantamkoc/personanlwebpage/backend/controller/IndexController.java
        return "Personal Web Page - Backend v1.0.0 - Gökhan TAMKOÇ";
=======
        return "Personal Web Page Backend v1.0.0 - Article Service";
>>>>>>> master:article-service/src/main/java/com/gokhantamkoc/personanlwebpage/backend/articleservice/controller/IndexController.java
    }
}
