package com.demo.restapi.service;

import com.demo.restapi.dto.UserDto;
import com.demo.restapi.entity.User;
import com.demo.restapi.exception.EmailAlreadyExistsException;
import com.demo.restapi.mapper.AutoUserMapper;
import com.demo.restapi.exception.ResourceNotFoundException;
import com.demo.restapi.mapper.UserMapper;
import com.demo.restapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto user) {
        //var userNew = UserMapper.mapToUserJpa(user);
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if(optionalUser.isPresent())
        {
            throw new EmailAlreadyExistsException("Email already exists for user!!");
        }
        var userNew = modelMapper.map(user, User.class);
       return UserMapper.mapToUserDto( userRepository.save(userNew));

    }

    @Override
    public UserDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User","Id", id)
        );

        return UserMapper.mapToUserDto( user);
    }

    @Override
    public UserDto updateUser(UserDto user) {
        Optional<User> result = userRepository.findById(user.getId());
        if(result.isPresent())
        {
            //UserMapper.mapToUserJpa(user)
          var savedUser=  userRepository.save(modelMapper.map(user, User.class) );
            //UserMapper.mapToUserDto(savedUser);
          return modelMapper.map(savedUser, UserDto.class);
        }
        return null;
    }

    @Override
    public void deleteUser(long id) {
        Optional<User> result = userRepository.findById(id);
        result.ifPresent(user -> userRepository.delete(user));

    }

    @Override
    public List<UserDto> getAllUsers() {
       var users = userRepository.findAll();
        ArrayList<UserDto> userDto = new ArrayList<>();
        for(User u:users)
        {
            //UserMapper.mapToUserDto(u))
            //This is MapStruct mapping
            userDto.add(AutoUserMapper.MAPPER.mapToUserDto(u)) ;
        }
        return userDto;
    }
}
