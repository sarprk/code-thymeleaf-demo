package com.demo.restapi.controller;

import com.demo.restapi.dto.UserDto;
import com.demo.restapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.internal.bytebuddy.build.Plugin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for User resource",
        description = "Create User, Update User, Delete User, Get User by Id, Get All Users"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users/")
public class UserController {
    private UserService userService;

    @Operation(
            summary = "Create user REST API",
            description = "Creates user rest api is used to save new user in Customr DB"
    )
    @PostMapping("create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user)
    {
       var result = userService.createUser( user);
       return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public  ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userid)
    {
        var user = userService.getUser(userid);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto user)
    {
        var result = userService.updateUser(user);
        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id)
    {
        userService.deleteUser(id);
        return new ResponseEntity<>("Record deleted successfully!!", HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<UserDto>> GetAllUsers()
    {
       var users = userService.getAllUsers();
       return new ResponseEntity<>(users, HttpStatus.OK);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request)
//    {
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(), exception.getMessage(), request.getDescription(false), "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }
}
