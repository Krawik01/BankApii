package com.krawik01.BankApi.service;

import com.krawik01.BankApi.mapper.AccountMapper;
import com.krawik01.BankApi.model.Account;
import com.krawik01.BankApi.model.DTO.AccountDTO;
import com.krawik01.BankApi.repository.AccountRepository;
import exception.AccountNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    @Override
    public Long showBalance(Long id) {
        return accountRepository.findById(id).get().getBalance();
    }

    @Override
    public AccountDTO createAccount(Account account) {
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.INSTANCE.accountToDTO(savedAccount);
    }

    @Override
    public List<Account> findAll() {
        return Optional.of(accountRepository.findAll())
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new AccountNotFoundException("no account available"));
    }
}
