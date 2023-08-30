package com.krawik01.BankApi.repository;

import com.krawik01.BankApi.model.*;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, Long> {
}
