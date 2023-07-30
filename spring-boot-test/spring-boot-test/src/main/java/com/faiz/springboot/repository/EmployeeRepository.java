package com.faiz.springboot.repository;

import com.faiz.springboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Long, Employee> {
}
 