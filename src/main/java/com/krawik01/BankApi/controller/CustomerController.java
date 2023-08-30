package com.krawik01.BankApi.controller;

import com.krawik01.BankApi.model.Customer;
import com.krawik01.BankApi.model.DTO.CustomerDTO;
import com.krawik01.BankApi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping()
    public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerDTO customerDTO){
        CustomerDTO customer = customerService.createCustomer(customerDTO);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
    @GetMapping("{id}/balance")
    public ResponseEntity<Map<Long, Long>> showBalance(@PathVariable Long id){
        Map<Long, Long> balances = customerService.showBalanceForAllAccounts(id);
        return ResponseEntity.ok(balances);
    }

    @GetMapping
    public ResponseEntity<?> showAll(){
        return ResponseEntity.ok(customerService.findAll());
    }
}
