package com.o2xp.mapper;

import com.o2xp.dto.CustomerDTO;
import com.o2xp.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO toDTO(Customer customer);
    Customer toModel(CustomerDTO customerDTO);
}
