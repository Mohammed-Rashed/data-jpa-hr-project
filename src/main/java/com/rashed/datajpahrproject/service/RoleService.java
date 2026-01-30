package com.rashed.datajpahrproject.service;

import com.rashed.datajpahrproject.entity.Role;
import com.rashed.datajpahrproject.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepo RoleRepo;


    public Role getRoleById(Long id) {
        return RoleRepo.findById(id).orElse(null);
    }
    public Role findByName(String name) {
        return RoleRepo.findByNameContaining(name).orElse(null);
    }
    public Role saveRole(Role Role) {
        return RoleRepo.save(Role);
    }
    public  Role updateRole(Role role) {
        Role roleObject = getRoleById(role.getId());
        roleObject.setName(role.getName());
        return RoleRepo.save(roleObject);
    }

}
