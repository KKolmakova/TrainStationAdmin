package com.kolmakova.services;

import com.kolmakova.entities.Account;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface AccountService {
    Optional<Account> getOne(String username);

    Account save(Account account) throws UsernameNotFoundException;
}
