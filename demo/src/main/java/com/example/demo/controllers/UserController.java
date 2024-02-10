package com.example.demo.controllers;

import com.example.demo.models.UserPo;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<UserPo> getUser() {
        return userService.getUser();
    }

    @GetMapping("/{id}") // Nouvelle méthode pour récupérer un utilisateur par ID
    public UserPo getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("/login")
    public Integer login(@RequestParam String email, @RequestParam String password) {
        return userService.login(email, password);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteAccountById(id);
    }

    @PutMapping("/update/{id}")
    public UserPo updateUser(@PathVariable Integer id, @RequestBody UserPo updatedUser) {
        return userService.updateAccount(id, updatedUser.getName(), updatedUser.getEmail(), updatedUser.getAddress(), updatedUser.getPassword());
    }

    @PostMapping()
    public UserPo saveUser(@RequestBody UserPo userPo) {
        return userService.createAccount(userPo);
    }
}

