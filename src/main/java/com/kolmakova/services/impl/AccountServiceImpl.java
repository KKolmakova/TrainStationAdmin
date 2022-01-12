package com.kolmakova.services.impl;

import com.kolmakova.entities.Account;
import com.kolmakova.repositories.UserRepository;
import com.kolmakova.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Optional<Account> getOne(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Account save(Account account) {
        String encryptedPassword = encoder.encode(account.getPassword());
        account.setPassword(encryptedPassword);
        return userRepository.save(account);
    }
}
