package com.demo.restapi.service;

import com.demo.restapi.dto.UserDto;
import com.demo.restapi.entity.User;

import java.util.List;

public interface UserService  {
    UserDto createUser(UserDto user);
    UserDto getUser(Long id);

    UserDto updateUser(UserDto user) ;

    void deleteUser(long id);

    List<UserDto> getAllUsers();
}
