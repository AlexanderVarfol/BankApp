package com.bankservice.app.controller;

import com.bankservice.app.dto.AccountDTO;
import com.bankservice.app.service.util.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AccountDTO")
//шаг 2 для связи с фронтом
public class AccountDTOController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/path")
    public AccountDTO getAccountDTO(){
        return AccountService.getAccountDTO;
    }

}
