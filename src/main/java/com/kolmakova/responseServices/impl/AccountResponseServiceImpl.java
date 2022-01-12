package com.kolmakova.responseServices.impl;

import com.kolmakova.dto.AccountDTO;
import com.kolmakova.entities.Account;
import com.kolmakova.responseServices.AccountResponseService;
import com.kolmakova.responses.AccountResponse;
import com.kolmakova.services.AccountService;
import com.kolmakova.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountResponseServiceImpl implements AccountResponseService {

    @Autowired
    private AccountService accountService;
    @Autowired
    private Converter converter;

    @Override
    public AccountResponse registerNewUser(AccountDTO accountDto) {
        AccountResponse response = new AccountResponse(true);
        Account accountToSave = converter.convertToAccount(accountDto);

        if (userNotExists(accountToSave)) {
            accountService.save(accountToSave);
            response.setUserAlreadyExists(false);
        }

        return response;
    }

    private boolean userNotExists(Account accountToSave) {
        return !accountService.getOne(accountToSave.getUsername()).isPresent();
    }
}
