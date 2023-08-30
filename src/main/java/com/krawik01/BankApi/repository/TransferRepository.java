package com.krawik01.BankApi.repository;

import com.krawik01.BankApi.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransferRepository extends JpaRepository<Transfer, Long> {


    @Override
    void deleteById(Long aLong);

    List<Transfer> findByFromAccount_AccountIdOrToAccount_AccountId(Long From, Long To);
}
