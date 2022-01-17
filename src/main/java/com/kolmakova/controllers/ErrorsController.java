package com.kolmakova.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/errors")
public class ErrorsController {

    @GetMapping("/accessDenied")
    public String getAccessDeniedPage() {
        return "/errors/403";
    }
}
