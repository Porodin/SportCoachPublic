package com.sportCoach.service;

import com.sportCoach.dto.UserDto;
import com.sportCoach.model.entity.User;

import java.util.List;

public interface IUserService {
    UserDto createUser(User user);

    UserDto updateUser(User user, Long id);

    String deleteUser(Long id);

    UserDto getUser(Long id);

    List<UserDto> getAllUsers();
}
