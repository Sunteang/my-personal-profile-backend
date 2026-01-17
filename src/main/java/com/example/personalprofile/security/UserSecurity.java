package com.example.personalprofile.security;

import com.example.personalprofile.services.UserService;
import org.springframework.stereotype.Component;

@Component("userSecurity")
public class UserSecurity {

    private final UserService userService;

    public UserSecurity(UserService userService) {
        this.userService = userService;
    }

    public boolean isOwner(Long userId, String username) {
        return userService.getUserById(userId)
                .map(user -> user.getUsername().equals(username))
                .orElse(false);
    }
}
