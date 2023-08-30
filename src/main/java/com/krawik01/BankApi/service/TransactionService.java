package com.krawik01.BankApi.service;

import com.krawik01.BankApi.model.DTO.*;
import com.krawik01.BankApi.model.*;

import java.util.List;

public interface TransactionService {
    TransactionDTO createTransaction(TransactionDTO transactionDTO);

    List<Transfer> findAll();
}
