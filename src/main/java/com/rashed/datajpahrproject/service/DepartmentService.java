package com.rashed.datajpahrproject.service;

import com.rashed.datajpahrproject.entity.Department;
import com.rashed.datajpahrproject.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;




    public Department getById(Long id) {
        return departmentRepo.findById(id).orElse(null);
    }
    public Department findByName(String name) {
        return departmentRepo.findByNameContaining(name).orElse(null);
    }
    public Department saveDepartment(Department department) {
        return departmentRepo.save(department);
    }
    public  Department updateDepartment(Department department) {
        Department dep = getById(department.getId());
        dep.setName(department.getName());
        return departmentRepo.save(dep);
    }
}
