package com.bankservice.app.service.util;

import com.bankservice.app.dto.AccountDTO;
import com.bankservice.app.entity.Account;

public interface AccountService {
    Account getAccountById(String id);

    AccountDTO getAccountDTO(String id);
}
