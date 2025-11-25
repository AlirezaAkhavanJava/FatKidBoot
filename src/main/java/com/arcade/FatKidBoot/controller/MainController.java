package com.arcade.FatKidBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping("")
    public String startMessage() {
        return "THE BACK-END IS WORKING FINE!";
    }
}
