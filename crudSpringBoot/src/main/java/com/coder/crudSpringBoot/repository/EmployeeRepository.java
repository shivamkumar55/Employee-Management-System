package com.coder.crudSpringBoot.repository;

import com.coder.crudSpringBoot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
