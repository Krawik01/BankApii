package com.krawik01.BankApi.controller;

import com.krawik01.BankApi.model.DTO.CustomerDTO;
import com.krawik01.BankApi.model.DTO.TransactionDTO;
import com.krawik01.BankApi.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping()
    public ResponseEntity<?> createTransaction(@Valid @RequestBody TransactionDTO transactionDTO){
        TransactionDTO transaction = transactionService.createTransaction(transactionDTO);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> showAllTransactions(){
        return ResponseEntity.ok(transactionService.findAll());
    }
}
