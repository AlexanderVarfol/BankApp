package com.bankservice.app.service.impl;

import com.bankservice.app.dto.AccountDTO;
import com.bankservice.app.entity.Account;
import com.bankservice.app.mapper.AccountMapper;
import com.bankservice.app.repository.AccountRepository;
import com.bankservice.app.service.util.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    @Transactional(timeout = 60,
            readOnly = true,
            isolation = Isolation.SERIALIZABLE)
    //совокупность операций в одну процесс/транзакцию   -   поведение метода или всех меодов   -   вместо написания кода вручную
    public Account getAccountById(String id) {
        return accountRepository.getById(UUID.fromString(id));
    }

    @Override
    public AccountDTO getAccountDTO(String id) {
        return accountMapper.toDTO(accountRepository.getAccountById(UUID.fromString(id)));
    }



}
