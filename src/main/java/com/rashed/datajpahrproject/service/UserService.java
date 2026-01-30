package com.rashed.datajpahrproject.service;

import com.rashed.datajpahrproject.entity.User;
import com.rashed.datajpahrproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo UserRepo;


    public User getUserById(Long id) {
        return UserRepo.findById(id).orElse(null);
    }
    public User findByName(String name) {
        return UserRepo.findByUsernameContaining(name).orElse(null);
    }
    public User saveUser(User user) {
        return UserRepo.save(user);
    }
    public  User updateUser(User user) {
        User userObject = getUserById(user.getId());
        userObject.setEmail(user.getEmail());
        userObject.setUsername(user.getUsername());
        return UserRepo.save(userObject);
    }

}
