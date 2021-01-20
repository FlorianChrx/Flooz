package com.owle.OwleAPI.controllers;

import com.owle.OwleAPI.model.User;
import com.owle.OwleAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public UserController() {
    }

    @PutMapping(path = {"/users/add"})
    public Map<String, Boolean> addUser(@RequestBody User user) {
        user.setRoles("ROLE_USER");
        return this.addUserByAdmin(user);
    }

    @PutMapping(path = {"/admin/users"})
    public Map<String, Boolean> addUserByAdmin(@RequestBody User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
        return Collections.singletonMap("success", this.userRepository.findById(user.getUsername()).isPresent());
    }

    @PostMapping(path = {"/admin/users/addrole"})
    public Map<String, Boolean> addRole(@RequestParam String username, @RequestParam String role) {
        return Collections.singletonMap("success", this.userRepository.addRole(username, "ROLE_".concat(role.toUpperCase())) == 1);
    }
}
