package com.krawik01.BankApi.service;

import com.krawik01.BankApi.mapper.CustomerMapper;
import com.krawik01.BankApi.model.Account;
import com.krawik01.BankApi.model.Customer;
import com.krawik01.BankApi.model.DTO.CustomerDTO;
import com.krawik01.BankApi.repository.AccountRepository;
import com.krawik01.BankApi.repository.CustomerRepository;
import exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;


    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.INSTANCE.dtoToCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.INSTANCE.customerToDTO(savedCustomer);
    }

    public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with the given id doesnt exist")));
    }

    @Override
    public Map<String, Long> showBalanceForAllAccounts(Long id) {
        List<Account> allAccounts = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"))
                .getAccounts();

        return allAccounts.stream()
                .collect(Collectors.toMap(
                        Account::getAccountNumber,
                        Account::getBalance
                ));
    }


    @Override
    public List<Customer> findAll() {
        return Optional.of(customerRepository.findAll())
                .filter(list -> !list.isEmpty())
                .orElseThrow(() -> new CustomerNotFoundException("no customer available"));
    }

    @Override
    public <S extends Customer> S save(S entity) {
        S savedEntity = customerRepository.save(entity);
        return Optional.ofNullable(savedEntity)
                .orElseThrow(() -> new CustomerNotFoundException("Failed to save the category"));

    }
}
