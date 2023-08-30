package com.krawik01.BankApi.service;

import exception.InsufficientAccountBalanceException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.krawik01.BankApi.repository.*;
import com.krawik01.BankApi.model.*;
import com.krawik01.BankApi.model.DTO.*;
import com.krawik01.BankApi.mapper.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final TransferRepository transferRepository;
    private final AccountRepository accountRepository;


    @Override
    @Transactional
    public TransferDTO createTransaction(TransferDTO transactionDTO) {
        Account accountFrom = accountRepository.findByAccountNumber(transactionDTO.getFromAccount().getAccountNumber());
        Account accountTo = accountRepository.findByAccountNumber(transactionDTO.getToAccount().getAccountNumber());

        Long balanceOnAccountFrom = accountFrom.getBalance();
        Long requestAmount = transactionDTO.getAmount();

        if (balanceOnAccountFrom >= requestAmount) {
            accountFrom.setBalance(balanceOnAccountFrom - requestAmount);
            accountTo.setBalance(accountTo.getBalance() + requestAmount);

            accountRepository.save(accountFrom);
            accountRepository.save(accountTo);

            Transfer transaction = TransferMapper.INSTANCE.dtoToTransaction(transactionDTO);
            transaction.setFromAccount(accountFrom);
            transaction.setToAccount(accountTo);
            transferRepository.save(transaction);

            return transactionDTO;
        } else {
            throw new InsufficientAccountBalanceException("insufficient account balance");
        }
    }


    @Override
    public List<Transfer> findAll() {
        return transferRepository.findAll();
    }
}