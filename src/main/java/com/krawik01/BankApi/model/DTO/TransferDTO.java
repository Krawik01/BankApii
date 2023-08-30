package com.krawik01.BankApi.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TransferDTO {

    private Long transactionId;
    private AccountDTO fromAccount;
    private AccountDTO toAccount;
    private Long amount;
    private LocalDateTime transactionDate = LocalDateTime.now();
}
