package com.bankservice.app.controller;

import com.bankservice.app.entity.Product;
import com.bankservice.app.entity.Transaction;
import com.bankservice.app.service.util.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping(value = "/{id}")
    public Transaction getTransactionById(@PathVariable("id")String id){

        Optional<Transaction> opt = transactionService.getTransactionById(id);

        if(opt.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "unreal id");
        }
        return opt.get();
    }
}
