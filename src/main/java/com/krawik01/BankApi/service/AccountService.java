package com.krawik01.BankApi.service;

import com.krawik01.BankApi.model.Account;
import com.krawik01.BankApi.model.DTO.AccountDTO;

import java.util.List;

public interface AccountService {

    Long showBalance(Long id);
    AccountDTO createAccount(Account account);

    List<Account> findAll();

    void deleteAccountByAccountId(Long id);

}
