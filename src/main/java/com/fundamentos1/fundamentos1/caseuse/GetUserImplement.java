package com.fundamentos1.fundamentos1.caseuse;

import com.fundamentos1.fundamentos1.entity.User;
import com.fundamentos1.fundamentos1.service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser{

    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();//todos los usuarios
    }
}
