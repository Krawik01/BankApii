package com.krawik01.BankApi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.krawik01.BankApi.model.*;
import com.krawik01.BankApi.model.DTO.*;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = getMapper(CustomerMapper.class);

    CustomerDTO customerToDTO(Customer customer);

    Customer dtoToCustomer(CustomerDTO dto);
}
