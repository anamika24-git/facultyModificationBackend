package com.esd.project.faculty.faculty_modification.controller;

import com.esd.project.faculty.faculty_modification.entity.Employee;
import com.esd.project.faculty.faculty_modification.exception.BusinessExaception;
import com.esd.project.faculty.faculty_modification.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EmployeeController {


    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/faculties")
    public List<Employee> getAllFaculties() {
        return employeeService.findAll();
    }

    @GetMapping("/faculties/{id}")
    public Employee findBYId(@PathVariable int id) {
        return employeeService.findBYId(id);
    }

    @PutMapping("/update_faculties")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee UpdateDetails) {
        try {
            employeeService.save(UpdateDetails);
            return ResponseEntity.ok("Faculty Details Updated successfully");
        } catch (Exception e) {
            // Handle exceptions, log errors, etc.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in faculty update");
        }

    }
    @PostMapping("/imagePath")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file ,
                                                   @RequestParam("facultyId") Integer id) throws BusinessExaception, IOException {

        employeeService.saveImage(file, id);
        return ResponseEntity.ok("Faculty Image Updated successfully");


    }
}


