package com.krawik01.BankApi.model.DTO;

import com.krawik01.BankApi.model.Account;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CustomerDTO {

    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Set<Account> accounts;
}
