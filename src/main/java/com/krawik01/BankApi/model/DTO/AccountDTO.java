package com.krawik01.BankApi.model.DTO;

import com.krawik01.BankApi.model.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AccountDTO {

    private Long accountId;
    private String accountNumber;
    private CustomerDTO customer;
    private Long balance;
    private String accountType;
    private List<TransactionDTO> outgoingTransactions;
    private List<TransactionDTO> incomingTransactions;
}


