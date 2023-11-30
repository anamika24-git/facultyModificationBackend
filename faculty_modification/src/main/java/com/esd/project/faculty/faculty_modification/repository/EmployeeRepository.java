package com.esd.project.faculty.faculty_modification.repository;

import com.esd.project.faculty.faculty_modification.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
  // JPA methods available to use no need to define
}
