package com.example.personalprofile.controllers;

import com.example.personalprofile.dto.response.ApiResponse;
import com.example.personalprofile.models.User;
import com.example.personalprofile.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService service) {
        this.userService = service;
    }

    // READ ALL USERS (ADMIN only)
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
        return ResponseEntity.ok(
                new ApiResponse<>("Users fetched successfully", 200, userService.getAllUsers())
        );
    }

    // READ ONE USER (ADMIN or owner)
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or @userSecurity.isOwner(#id, principal.username)")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(user -> ResponseEntity.ok(
                        new ApiResponse<>("User fetched successfully", 200, user)
                ))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ApiResponse<>("User not found", 404, null)
                ));
    }

    // CREATE USER (ADMIN only)
    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<User>> createUser(@RequestBody User user) {
        User created = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ApiResponse<>("User created successfully", 201, created)
        );
    }

    // UPDATE USER (ADMIN or owner)
    @PostMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN') or @userSecurity.isOwner(#id, principal.username)")
    public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable Long id,
                                                        @RequestBody User user) {
        User updated = userService.updateUser(id, user);
        return ResponseEntity.ok(
                new ApiResponse<>("User updated successfully", 200, updated)
        );
    }

    // DELETE USER (ADMIN only)
    @PostMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(
                new ApiResponse<>("User deleted successfully", 200, null)
        );
    }
}
