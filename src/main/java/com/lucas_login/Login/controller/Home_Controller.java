package com.lucas_login.Login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class Home_Controller {

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String admin() {
        return "Admin";
    }

    @GetMapping("/home")
    public String home() {
        return "Home";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('USER')")
    public String user() {
        return "Bienvenido usuario";
    }
}

@Controller
class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
