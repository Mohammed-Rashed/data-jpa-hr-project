package com.rashed.datajpahrproject.service;

import com.rashed.datajpahrproject.entity.Employee;
import com.rashed.datajpahrproject.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;


    public Employee getEmployeeById(Long id) {
        return employeeRepo.findById(id).orElse(null);
    }
    public Employee findByName(String name) {
        return employeeRepo.findByNameContaining(name).orElse(null);
    }
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
    public  Employee updateEmployee(Employee employee) {
        Employee emp = getEmployeeById(employee.getId());
        emp.setName(employee.getName());
        emp.setSalary(employee.getSalary());
        emp.setDepartment(employee.getDepartment());
        return employeeRepo.save(emp);
    }
}
