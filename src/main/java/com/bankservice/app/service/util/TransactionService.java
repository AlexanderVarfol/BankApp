package com.bankservice.app.service.util;

import com.bankservice.app.entity.Transaction;

import java.util.Optional;

public interface TransactionService {

    Optional<Transaction> getTransactionById(String id);

}
