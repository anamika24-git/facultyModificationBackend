package com.esd.project.faculty.faculty_modification.repository;

import com.esd.project.faculty.faculty_modification.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Query(value = "SELECT * FROM courses where employee_id IS NULL", nativeQuery = true)
    List<Course> getAvailableCourses();

    @Query(value = "SELECT * FROM courses where employee_id = :facultyId", nativeQuery = true)
    List<Course> getOfferedCourses(int facultyId);

    @Modifying
    @Query(value = "UPDATE courses SET employee_id = :facultyId WHERE course_id = :courseId" ,nativeQuery = true)
    void addFacultyCourses(Long courseId , Long facultyId);
    @Modifying
    @Query(value = "UPDATE courses  SET employee_id = NULL WHERE course_id = :courseId" ,nativeQuery = true)
    void removeFacultyCourses(Long courseId);


}
