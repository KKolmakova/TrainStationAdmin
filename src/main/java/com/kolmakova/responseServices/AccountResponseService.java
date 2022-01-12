package com.kolmakova.responseServices;

import com.kolmakova.dto.AccountDTO;
import com.kolmakova.responses.AccountResponse;

public interface AccountResponseService {
    AccountResponse registerNewUser(AccountDTO accountDto);
}
