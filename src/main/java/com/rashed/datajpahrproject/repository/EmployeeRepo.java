package com.rashed.datajpahrproject.repository;

import com.rashed.datajpahrproject.entity.Employee;
import com.rashed.datajpahrproject.projection.EmployeePorjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    Optional<Employee> findByNameContaining(String name);
    @EntityGraph(attributePaths = {"department"}) //  {"department","user"}
    List<Employee> findByDepartmentId(Long departmentId);

     Optional<EmployeePorjection> findProjectedById(Long id) ;

     @Query("select emp.id as id , emp.salary as salary , emp.name as name, emp.department.id as departmentId  from Employee emp where (emp.salary = :keyword or emp.name like concat('%', :keyword, '%') ) or emp.id=2")
     Page<EmployeePorjection> filter(@Param("keyword") String keyword, Pageable sort);
}
