package org.example.productcatalogservice_july2024.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("{id}")
    public String getMessage(@PathVariable Long id) {
        if(id == 0) {
            throw new IllegalArgumentException("id is bad");
        }
        return "Welcome to Project Module";
    }
}
