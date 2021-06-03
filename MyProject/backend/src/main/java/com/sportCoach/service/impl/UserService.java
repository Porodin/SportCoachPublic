package com.sportCoach.service.impl;

import com.sportCoach.dto.UserDto;
import com.sportCoach.model.entity.User;
import com.sportCoach.repository.IUserRepository;
import com.sportCoach.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final ModelMapper mapper;

    @Autowired
    public UserService(IUserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public UserDto createUser(User user) {
        userRepository.save(user);
        return mapper.map(user, getDtoClass());
    }

    @Override
    public UserDto updateUser(User source, Long id) {
        Optional<User> userForUpdate = userRepository.findById(id);
        if (userForUpdate.isPresent()) {
            User target = userForUpdate.get();
            target.setDateOfBirth(source.getDateOfBirth());
            target.setCity(source.getCity());
            target.setPhone(source.getPhone());
            target.setGmail(source.getGmail());
            target.setUserName(source.getUserName());
            this.userRepository.save(target);
            return mapper.map(target, getDtoClass());
        }
        return mapper.map(new User(), getDtoClass());
    }

    @Override
    @Transactional
    public String deleteUser(Long id) {
            Optional<User> userForDelete = userRepository.findById(id);
            if (userForDelete.isPresent()) {
                userRepository.delete(userForDelete.get());
                return String.format("User with id: %s was successfully removed", id);
            } else {
                return String.format("User with id: %s doesn't exist", id);
            }
        }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public UserDto getUser(Long id) {
        Optional<User> foundUser = userRepository.findById(id);
        if (foundUser.isPresent()) {
            return mapper.map(foundUser.get(), getDtoClass());
        } else {
            return mapper.map(new User(), getDtoClass());
        }
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<UserDto> getAllUsers() {
        List<User> listOfUsers = userRepository.findAll();
        return listOfUsers.stream().map(user -> mapper.map(user, getDtoClass())).collect(Collectors.toList());
    }

    private Class<UserDto> getDtoClass() {
        return UserDto.class;
    }
}
