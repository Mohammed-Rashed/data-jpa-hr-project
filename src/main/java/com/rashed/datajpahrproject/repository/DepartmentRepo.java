package com.rashed.datajpahrproject.repository;

import com.rashed.datajpahrproject.entity.Department;
import com.rashed.datajpahrproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {
    Optional<Department> findByNameContaining(String name);
}
