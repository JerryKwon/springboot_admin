package com.fastcampus.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController{

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getMethod(){
        return "Hello Spring Boot";
    }

}