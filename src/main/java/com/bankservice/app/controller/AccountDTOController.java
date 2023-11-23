package com.bankservice.app.controller;

import com.bankservice.app.dto.AccountDTO;
import com.bankservice.app.service.util.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AccountDTO")
//шаг 2 для связи с фронтом
public class AccountDTOController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public AccountDTO getAccountDTOById(@PathVariable("id") String id){
        return accountService.getAccountDTO(id);
    }

}
