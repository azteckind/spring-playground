package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/task")
    public String getTasks() {
        return "These are tasks";
    }//Responding to a HTTP request

    @PostMapping("/tasks")
    public String createTask() {
        return "You just POST'd to /tasks";
    }//Posting to a HTTP request

    @GetMapping("/math/pi")
    public double getPI() {
        return 3.141592653589793;
    }//PI with GET request

}