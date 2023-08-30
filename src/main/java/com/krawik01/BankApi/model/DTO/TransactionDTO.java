package com.krawik01.BankApi.model.DTO;

import com.krawik01.BankApi.model.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TransactionDTO {

    private Long transactionId;
    private AccountDTO fromAccount;
    private AccountDTO toAccount;
    private Long amount;
    private LocalDateTime transactionDate = LocalDateTime.now();
}
