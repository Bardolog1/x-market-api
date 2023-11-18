package com.bardolog1.xmarket.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sayHello")
public class HellloWorldController {
    @GetMapping("/bardolog1")
    public String sayHello(){
        return "Hey, this is an market API with Spring framework!";
    }


}
