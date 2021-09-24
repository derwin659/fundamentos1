package com.fundamentos1.fundamentos1.caseuse;

import com.fundamentos1.fundamentos1.entity.User;
import com.fundamentos1.fundamentos1.service.UserService;
import org.springframework.stereotype.Component;

@Component//nos conviene porque son casos de uso
public class CreateUser {
    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }


    public User save(User newUser) {
        return userService.save(newUser);
    }
}
