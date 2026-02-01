package com.rashed.datajpahrproject.controller;

import com.rashed.datajpahrproject.entity.Employee;
import com.rashed.datajpahrproject.projection.EmployeePorjection;
import com.rashed.datajpahrproject.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("find/{id}")
    public EmployeePorjection findById(@PathVariable Long id) {
        return employeeService.findProjectedById(id);
    }
    @GetMapping("find-by-name/{name}")
    public Employee findByName(@PathVariable String name) {
        return employeeService.findByName(name);
    }
    @PostMapping()
    public  Employee save(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

//    @PutMapping()
//    public  Employee update(@RequestBody Employee employee) {
//        return employeeService.updateEmployee(employee);
//    }
    @GetMapping("find-by-department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable Long departmentId) {
        return employeeService.findByDepartment(departmentId);
    }

}
