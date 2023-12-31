package com.krawik01.BankApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "Accounts")
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;
    @Column(name="account_number")
    private String accountNumber;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Column(name = "balance")
    private Long balance;
    @Column(name = "account_type")
    private String accountType;
    @JsonIgnore
    @OneToMany(mappedBy = "fromAccount",cascade = CascadeType.MERGE)
    private List<Transfer> outgoingTransactions;
    @JsonIgnore
    @OneToMany(mappedBy = "toAccount", cascade = CascadeType.MERGE)
    private List<Transfer> incomingTransactions;

}
