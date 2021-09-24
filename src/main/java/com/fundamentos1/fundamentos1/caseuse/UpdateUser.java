package com.fundamentos1.fundamentos1.caseuse;

import com.fundamentos1.fundamentos1.entity.User;
import com.fundamentos1.fundamentos1.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User update(User newUser, Long id) {
        return userService.update(newUser,id);
    }
}
