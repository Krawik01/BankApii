package com.krawik01.BankApi.service;

import com.krawik01.BankApi.model.Customer;
import com.krawik01.BankApi.model.DTO.CustomerDTO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CustomerService {

    CustomerDTO createCustomer(CustomerDTO customerDTO);

    Optional<Customer> findById(Long id);

    Map<Long, Long> showBalanceForAllAccounts(Long id);

    List<Customer> findAll();

    <S extends Customer> S save(S entity);
}
