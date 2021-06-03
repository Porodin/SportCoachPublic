package com.sportCoach;

import com.sportCoach.model.entity.User;
import com.sportCoach.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

public class FacebookConnectionSignup implements ConnectionSignUp {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public String execute(Connection<?> connection) {
        User user = new User();
        user.setUserName(connection.getDisplayName());
        iUserRepository.save(user);
        return user.getUserName();
    }
}
