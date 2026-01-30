package com.rashed.datajpahrproject.controller;

import com.rashed.datajpahrproject.entity.Employee;
import com.rashed.datajpahrproject.entity.User;
import com.rashed.datajpahrproject.service.EmployeeService;
import com.rashed.datajpahrproject.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("find/{id}")
    public User findById(@PathVariable Long id) {
        return userService.getUserById(id);
    }


}
