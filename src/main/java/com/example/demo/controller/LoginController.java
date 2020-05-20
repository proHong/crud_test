package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public void login(){

    }

    @GetMapping("/logout")
    public void logout(){

    }

    @GetMapping("/accessDenied")
    public void AccessDenied(){

    }
}