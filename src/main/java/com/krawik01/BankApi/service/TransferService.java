package com.krawik01.BankApi.service;

import com.krawik01.BankApi.model.DTO.*;
import com.krawik01.BankApi.model.*;

import java.util.List;

public interface TransferService {
    TransferDTO createTransaction(TransferDTO transactionDTO);

    List<Transfer> findAll();
}
