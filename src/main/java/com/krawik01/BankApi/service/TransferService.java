package com.krawik01.BankApi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.krawik01.BankApi.repository.*;
import com.krawik01.BankApi.model.*;
import com.krawik01.BankApi.model.DTO.*;
import com.krawik01.BankApi.service.*;
import com.krawik01.BankApi.mapper.*;
import com.krawik01.BankApi.controller.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferService implements TransactionService{

    private final TransferRepository transferRepository;
    private final AccountRepository accountRepository;


    @Override
    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {

        Account accountFrom = accountRepository.findById(transactionDTO.getFromAccount().getAccountId()).get();

        Long balanceOnAccountFrom = accountFrom.getBalance();
        Long requestAmount = transactionDTO.getAmount();

        if (balanceOnAccountFrom >= requestAmount) {

            Transfer transaction = TransactionMapper.INSTANCE.dtoToTransaction(transactionDTO);
            Transfer savedTransaction = transferRepository.saveAndFlush(transaction);

//            accountRepository.deleteById(accountFrom.getAccountId());
//            accountFrom.setBalance(accountFrom.getBalance() + requestAmount);
//            accountRepository.save(accountFrom);
            return TransactionMapper.INSTANCE.transactionToDTO(savedTransaction);
        } else {
            try {
                throw new Exception("no money on account");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Transfer> findAll() {
        return transferRepository.findAll();
    }
}