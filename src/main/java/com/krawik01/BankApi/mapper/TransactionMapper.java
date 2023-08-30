package com.krawik01.BankApi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.krawik01.BankApi.model.*;
import com.krawik01.BankApi.model.DTO.*;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionMapper INSTANCE = getMapper(TransactionMapper.class);

    TransactionDTO transactionToDTO(Transfer transaction);

    Transfer dtoToTransaction(TransactionDTO dto);
}

