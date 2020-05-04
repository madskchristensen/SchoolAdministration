package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error")
    public String handleError(){

        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
