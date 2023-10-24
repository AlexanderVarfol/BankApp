package com.bankservice.app.service.impl;

import com.bankservice.app.entity.Transaction;
import com.bankservice.app.repository.TransactionRepository;
import com.bankservice.app.service.util.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public Optional<Transaction> getTransactionById(String id) {
        return transactionRepository.findById(Integer.parseInt(id));
    }
}
