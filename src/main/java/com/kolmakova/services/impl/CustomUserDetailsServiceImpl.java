package com.kolmakova.services.impl;

import com.kolmakova.entities.Account;
import com.kolmakova.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Optional;

@Service
@Transactional
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> accountOptional = usersRepository.findByUsername(username);

        if (accountOptional.isPresent()) {
            return convertToUserDetails(accountOptional.get());
        } else {
            throw new UsernameNotFoundException(String.format("User with name %s not found", username));
        }
    }

    private UserDetails convertToUserDetails(Account account) {
        return new User(
                account.getUsername(),
                account.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(account.getRole()))
        );
    }
}
