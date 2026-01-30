package com.rashed.datajpahrproject.controller;

import com.rashed.datajpahrproject.entity.Department;
import com.rashed.datajpahrproject.entity.Employee;
import com.rashed.datajpahrproject.service.DepartmentService;
import com.rashed.datajpahrproject.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("departments")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("find/{id}")
    public Department findById(@PathVariable Long id) {
        return departmentService.getById(id);
    }
    @GetMapping("find-by-name/{name}")
    public Department findByName(@PathVariable String name) {
        return departmentService.findByName(name);
    }
    @PostMapping()
    public  Department save(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @PutMapping()
    public  Department update(@RequestBody Department department) {
        return departmentService.updateDepartment(department);
    }

}
