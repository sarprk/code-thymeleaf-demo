package com.demo.restapi.mapper;

import com.demo.restapi.dto.UserDto;
import com.demo.restapi.entity.User;

public class UserMapper {
    //Converts user JPA to User DTO
    public static UserDto mapToUserDto(User user)
    {
        return new UserDto( user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());

    }

    public static User mapToUserJpa(UserDto user)
    {
        return new User(user.getId(), user.getFirstName(),user.getLastName(),user.getEmail());
    }
}
