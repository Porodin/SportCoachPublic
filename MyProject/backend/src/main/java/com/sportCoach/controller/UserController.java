package com.sportCoach.controller;

import com.sportCoach.dto.UserDto;
import com.sportCoach.model.entity.User;
import com.sportCoach.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/registration")
    //Вызов метода httpPost
    public ResponseEntity<UserDto> createUser(@RequestBody User user) {
        UserDto result = userService.createUser(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/user/{id}")
    //Данная аннотация означает, что при переходе по ссылке /user/{id}
    //выполнится функциональность данного метода
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        UserDto result = userService.getUser(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/users")
    public ResponseEntity<List<UserDto>> getUser() {
        List<UserDto> result = userService.getAllUsers();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(path = "/user/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody User source, @PathVariable Long id) {
        UserDto result = userService.updateUser(source, id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(path = "/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }
}
