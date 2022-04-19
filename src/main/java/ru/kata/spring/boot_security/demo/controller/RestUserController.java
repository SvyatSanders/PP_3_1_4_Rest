package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@RequestMapping("/admin/api/users")
@RestController
public class RestUserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> showAllUsers() {
        List<User> list = userService.getAllUsers();
        return list;
    }

    @GetMapping("/{id}")
    public User showUser(@PathVariable long id) {
        User user = userService.getUserById(id);
        return user;
    }

    @GetMapping("/auth_user")
    public User getAuthUser() {
        return userService.getAuthUser();
    }

    @PostMapping
    public List<User> addUser(@RequestBody User user) {
        System.out.println(user.toString());
        userService.saveUser(user);
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public List<User> updateUser(@RequestBody User user, @PathVariable Long id) {
        user.setId(id);
        userService.updateUser(user);
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public List<User> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return userService.getAllUsers();
    }
}