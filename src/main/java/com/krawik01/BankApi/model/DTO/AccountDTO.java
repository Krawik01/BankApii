package com.krawik01.BankApi.model.DTO;

import lombok.*;

import java.util.List;

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
    private List<TransferDTO> outgoingTransactions;
    private List<TransferDTO> incomingTransactions;
}


