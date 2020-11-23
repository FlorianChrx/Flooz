package com.owle.OwleAPI.controllers;

import com.owle.OwleAPI.model.User;
import com.owle.OwleAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PutMapping(path = "/users/add")
    public @ResponseBody
    Map<String, Boolean> addUser(@RequestBody User user) {
        user.setRoles("USER");
        return addUserByAdmin(user);
    }

    @PutMapping(path = "/admin/users")
    public @ResponseBody
    Map<String, Boolean> addUserByAdmin(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return Collections.singletonMap("success", userRepository.findById(user.getUsername()).isPresent());
    }

}
