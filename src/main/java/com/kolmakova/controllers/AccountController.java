package com.kolmakova.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class AccountController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/generate")
    public String generatePassword(@RequestParam(value = "pass", required = false) String pass, Model model) {
        if (StringUtils.isNotEmpty(pass)) {
            model.addAttribute("generate", true);
            model.addAttribute("pass", passwordEncoder.encode(pass));
        }
        return "generatePassword";
    }

    @GetMapping("/signIn")
    public String getSignInPage(Model model) {
        model.addAttribute("signIn", true);

        return "security";
    }
}
