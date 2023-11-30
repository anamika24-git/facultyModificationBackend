package com.esd.project.faculty.faculty_modification.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
 @Entity()
 @Table(name = "employees")
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="employee_id")
        private int eid;

        @Column(name="first_name" , nullable = false)
        private String fname;

        @Column(name="last_name")
        private String lname;

      @Column(name="email" , nullable = false)
     private String email;
     @Column(name="title")
     private String title;
     @Column(name="photograph_path")
     private String ppath;

     @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
     @JoinColumn(name = "department_id" ,unique = true)
     private Department department;

     @JsonIgnore
     @OneToMany(mappedBy = "employee", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
     private List<Course> course;
 }


