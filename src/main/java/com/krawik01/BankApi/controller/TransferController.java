package com.krawik01.BankApi.controller;

import com.krawik01.BankApi.model.DTO.TransferDTO;
import com.krawik01.BankApi.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @PostMapping()
    public ResponseEntity<?> createTransaction(@Valid @RequestBody TransferDTO transferDTO){
        TransferDTO transaction = transferService.createTransaction(transferDTO);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> showAllTransactions(){
        return ResponseEntity.ok(transferService.findAll());
    }
}
