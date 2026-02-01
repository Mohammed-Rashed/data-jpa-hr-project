package com.rashed.datajpahrproject.repository;

import com.rashed.datajpahrproject.entity.Employee;
import com.rashed.datajpahrproject.projection.EmployeePorjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    Optional<Employee> findByNameContaining(String name);
    @EntityGraph(attributePaths = {"department"}) //  {"department","user"}
    List<Employee> findByDepartmentId(Long departmentId);

     Optional<EmployeePorjection> findProjectedById(Long id) ;

}
