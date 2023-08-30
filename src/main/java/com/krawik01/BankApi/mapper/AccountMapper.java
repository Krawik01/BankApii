package com.krawik01.BankApi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.krawik01.BankApi.model.Account;
import com.krawik01.BankApi.model.DTO.AccountDTO;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
    AccountDTO accountToDTO(Account account);
    Account dtoToAccount(AccountDTO dto);
}
