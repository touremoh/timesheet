package com.o2xp.mapper;

import com.o2xp.dto.UserDTO;
import com.o2xp.model.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserProfileMapper {
    UserProfileMapper INSTANCE = Mappers.getMapper(UserProfileMapper.class);

    UserDTO toDTO(UserProfile userProfile);
    UserProfile toModel(UserDTO userDTO);
}
