package com.example.meu_jwt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teste")
public class TesteController {

    @PreAuthorize("hasRole('USER')")
    @GetMapping("user")
    public String testeUser() {
        return "User ok!";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("admin")
    public String testeAdmin() {
        return "Admin ok!";
    }
}
