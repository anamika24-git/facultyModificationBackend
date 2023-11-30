package com.esd.project.faculty.faculty_modification.service;

import com.esd.project.faculty.faculty_modification.entity.Employee;
import com.esd.project.faculty.faculty_modification.exception.BusinessExaception;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findBYId(int theId);

    void save(Employee theEmployee);

    public void saveImage(MultipartFile file, Integer id) throws BusinessExaception, IOException;

    //void deleteById(int theId);
}
