package com.rashed.datajpahrproject.service;

import com.rashed.datajpahrproject.entity.Employee;
import com.rashed.datajpahrproject.projection.EmployeePorjection;
import com.rashed.datajpahrproject.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;


    public EmployeePorjection findProjectedById(Long id) {
        return employeeRepo.findProjectedById(id).orElse(null);
    }
    public Employee findByName(String name) {
        return employeeRepo.findByNameContaining(name).orElse(null);
    }
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
//    public  Employee updateEmployee(Employee employee) {
//        Employee emp = (Employee) getEmployeeById(employee.getId());
//        emp.setName(employee.getName());
//        emp.setSalary(employee.getSalary());
//        emp.setDepartment(employee.getDepartment());
//        return employeeRepo.save(emp);
//    }
    public List<Employee> findByDepartment(Long departmentId) {
        return employeeRepo.findByDepartmentId(departmentId);
    }
    public Page<EmployeePorjection> filter(String keyword, Pageable sort) {
        return employeeRepo.filter(keyword,sort);
    }
}
