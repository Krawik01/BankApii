package com.krawik01.BankApi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.krawik01.BankApi.model.*;
import com.krawik01.BankApi.model.DTO.*;

@Mapper
public interface TransferMapper {
    TransferMapper INSTANCE = Mappers.getMapper(TransferMapper.class);

    TransferDTO transactionToDTO(Transfer transfer);

    Transfer dtoToTransaction(TransferDTO dto);
}

