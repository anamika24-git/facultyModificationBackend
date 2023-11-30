package com.esd.project.faculty.faculty_modification.service;
import java.io.File;
import java.io.IOException;
import java.util.*;
import com.esd.project.faculty.faculty_modification.entity.Employee;
import com.esd.project.faculty.faculty_modification.exception.BusinessExaception;
import com.esd.project.faculty.faculty_modification.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
   private static final String facultyModificationHome = "/Users/anamikamishra/Documents/FacultyImage";

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();

    }

    @Override
    public Employee findBYId(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee foundemp = null;
        if(result.isPresent())
        {
            foundemp = result.get();

        }
        else {
            throw new RuntimeException("Did not found employee id - " + theId);
        }
        return foundemp;
    }



    @Override
    public void save(Employee updatedEmp){
        employeeRepository.save(updatedEmp);
    }

    @Override
    @Transactional
    public void saveImage(MultipartFile file, Integer id) throws BusinessExaception,IOException {
        String filename = file.getOriginalFilename();
        String finalFilepath = facultyModificationHome + File.separator + filename;
        System.out.println("finalfilepath" + finalFilepath);
        file.transferTo(new File(finalFilepath));
        Optional<Employee> byId = employeeRepository.findById(id);
        if(byId.isPresent()) {
            Employee emp = byId.get();
            emp.setPpath(finalFilepath);
            employeeRepository.save(emp);
        } else {
            throw new BusinessExaception("User doesn't exist");

        }

    }
}

