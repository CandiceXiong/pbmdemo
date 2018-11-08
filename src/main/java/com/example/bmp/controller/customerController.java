package com.example.bmp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class customerController {
    @Autowired
    @RequestMapping(value = "/add")
    public String index()
    {
        System.out.println ("");
        return "出来了";
    }
}
