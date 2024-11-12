package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.UserDTO;
import com.exo1.exo1.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);
    
}
