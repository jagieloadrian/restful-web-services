package com.anjo.rest.webservices.restfulwebservices.controller;

import com.anjo.rest.webservices.restfulwebservices.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // GET method - "Hello World'
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

    //hello-world-bean
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World!");
    }
}
