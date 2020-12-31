package com.o2xp.mapper;

import com.o2xp.dto.ContractDTO;
import com.o2xp.model.Contract;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContractMapper {
    ContractMapper INSTANCE = Mappers.getMapper(ContractMapper.class);

    @Mapping(source = "contract.customer.id", target = "customer.id")
    @Mapping(source = "contract.userProfile.id", target = "userProfile.id")
    ContractDTO toDTO(Contract contract);

    @Mapping(source = "contractDTO.customer.id", target = "customer.id")
    @Mapping(source = "contractDTO.userProfile.id", target = "userProfile.id")
    Contract toModel(ContractDTO contractDTO);
}
