package com.krawik01.BankApi.controller;

import com.krawik01.BankApi.model.Account;
import com.krawik01.BankApi.model.DTO.AccountDTO;
import com.krawik01.BankApi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping()
    public ResponseEntity<?> createAccount(@Valid @RequestBody Account accountDTO) {
        AccountDTO account = accountService.createAccount(accountDTO);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> showAll(){
        return ResponseEntity.ok(accountService.findAll());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccountByAccountId(id);
        return ResponseEntity.noContent().build();
    }


}
