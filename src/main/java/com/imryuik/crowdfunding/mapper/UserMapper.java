package com.imryuik.crowdfunding.mapper;

import com.imryuik.crowdfunding.dto.UserDTO;
import com.imryuik.crowdfunding.dto.UserGDTO;
import com.imryuik.crowdfunding.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserGDTO userToUserGDTO(User user);

    User userGDTOToUser(UserGDTO userGDTO);
}
