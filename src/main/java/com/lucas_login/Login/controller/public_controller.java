package com.lucas_login.Login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/public")
@RequiredArgsConstructor

public class public_controller {
    @GetMapping("/home")
    public String home(){
        return "Public Home";
    }
}
