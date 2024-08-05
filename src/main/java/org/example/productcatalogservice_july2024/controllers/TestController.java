package org.example.productcatalogservice_july2024.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String getMessage() {
        return "Welcome to Project Module";
    }
}
