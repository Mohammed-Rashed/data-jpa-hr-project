package com.rashed.datajpahrproject.config;

import com.rashed.datajpahrproject.entity.Role;
import com.rashed.datajpahrproject.entity.User;
import com.rashed.datajpahrproject.service.RoleService;
import com.rashed.datajpahrproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class AppStartUp implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        //create roles
        Role roleAdmin = new Role();
        roleAdmin.setName("Admin");
        roleService.saveRole(roleAdmin);


        Role roleUser = new Role();
        roleUser.setName("User");
        roleService.saveRole(roleUser);

        Set<Role> AdminRoles = new HashSet<>();
        AdminRoles.add(roleAdmin);

        Set<Role> UserRole = new HashSet<>();
        UserRole.add(roleUser);

        User user = new User();
        user.setUsername("Rashed");
        user.setEmail("rashed@example.com");
        user.setRoles(AdminRoles);
        userService.saveUser(user);

        User user2 = new User();
        user2.setUsername("Mohamed");
        user2.setEmail("morashed@example.com");
        user2.setRoles(UserRole);
        userService.saveUser(user2);
    }
}
