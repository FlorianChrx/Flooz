package fr.da2i.flooz.controllers;

import fr.da2i.flooz.model.User;
import fr.da2i.flooz.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@CrossOrigin
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
        if (userRepository.existsById(user.getUsername())) return Collections.singletonMap("success", false);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
        return Collections.singletonMap("success", this.userRepository.findById(user.getUsername()).isPresent());
    }

    @PostMapping(path = {"/admin/users/addrole"})
    public Map<String, Boolean> addRole(@RequestParam String username, @RequestParam String role) {
        return Collections.singletonMap("success", this.userRepository.addRole(username, "ROLE_".concat(role.toUpperCase())) == 1);
    }

    @PostMapping(path = {"/users/authenticate"})
    public User authenticate(@RequestBody Map<String, String> user) {
        if (passwordEncoder.matches(user.get("password"), userRepository.findById(user.get("username")).get().getPassword()))
            return userRepository.findById(user.get("username")).get();
        return null;
    }
}
