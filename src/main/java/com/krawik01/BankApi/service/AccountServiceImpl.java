package com.krawik01.BankApi.service;

import com.krawik01.BankApi.mapper.AccountMapper;
import com.krawik01.BankApi.model.Account;
import com.krawik01.BankApi.model.DTO.AccountDTO;
import com.krawik01.BankApi.model.Transfer;
import com.krawik01.BankApi.repository.AccountRepository;
import com.krawik01.BankApi.repository.TransferRepository;
import exception.AccountAlreadyExistException;
import exception.AccountNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final TransferRepository transferRepository;
    @Override
    public Long showBalance(Long id) {
        return accountRepository.findById(id).get().getBalance();
    }

    @Override
    public AccountDTO createAccount(Account account) {
        Account accountExist = accountRepository.findAccountByAccountNumber(account.getAccountNumber());
        if(accountExist == null){
            Account savedAccount = accountRepository.save(account);
            return AccountMapper.INSTANCE.accountToDTO(savedAccount);
        } else {
            throw new AccountAlreadyExistException("account already exists");
        }

    }

    @Override
    public List<Account> findAll() {
        return Optional.of(accountRepository.findAll())
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new AccountNotFoundException("no account available"));
    }

    @Override
    @Transactional
    public void deleteAccountByAccountId(Long id) {
        Account accountExist = accountRepository.findById(id).orElse(null);

        if (accountExist != null) {
            List<Transfer> transactionsToDelete =
                    transferRepository.
                            findByFromAccount_AccountIdOrToAccount_AccountId(accountExist.getAccountId(), accountExist.getAccountId());

            transferRepository.deleteAll(transactionsToDelete);

            accountRepository.delete(accountExist);
        } else {
            throw new AccountNotFoundException("Cannot delete account. Account doesn't exist.");
        }
    }

}
