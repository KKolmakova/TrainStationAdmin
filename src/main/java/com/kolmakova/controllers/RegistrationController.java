package com.kolmakova.controllers;

import com.kolmakova.entities.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {

//    @Autowired
//    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Account account, Map<String, Object> model) {
//        Optional<Account> accountDB = userRepository.findByUsername(account.getUsername());
//
//        if (accountDB.isPresent()) {
//            model.put("message", "User already exists!");
//            return "/registration";
//        }
//
////        account.setRoles(Collections.singletonList(UserRole.ADMIN));
//        userRepository.save(account);

        return "redirect:/login";
    }
}
