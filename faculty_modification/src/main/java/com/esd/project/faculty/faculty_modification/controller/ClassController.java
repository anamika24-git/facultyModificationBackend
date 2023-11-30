package com.esd.project.faculty.faculty_modification.controller;


import com.esd.project.faculty.faculty_modification.entity.Course;
import com.esd.project.faculty.faculty_modification.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ClassController {
    private CourseService courseService;

    public ClassController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/availableCourses")
    public List<Course> getAvailableCourses() {
        return courseService.getAvailableCourses();
    }

    @GetMapping("/coursesById/{courseId}")
    public Course getCourseId(@PathVariable  int courseId) {
        return courseService.getCourseId(courseId);
    }

    @GetMapping("/offeredCourses/{facultyId}")
    public List<Course> getOfferedCourses(@PathVariable  int facultyId) {
        return courseService.getOfferedCourses(facultyId);
    }

    /*@PutMapping("/updateFaculty/{facultyId}/{courseId}")
    public ResponseEntity<String> updateFacultyForCourse(
            @PathVariable int facultyId,
            @PathVariable int courseId) {

        try {
            courseService.updatefacultyIDForCourse(facultyId, courseId);
            return ResponseEntity.ok("Faculty updated successfully");
        } catch (Exception e) {
            // Handle exceptions, log errors, etc.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating faculty");
        }
    }*/


        @PutMapping("/addCourses")
        public ResponseEntity<String> addFacultyCourses(
                @RequestBody FacultyCourseRequest request) {

            try {
                courseService.addFacultyCourses(request);
                return new ResponseEntity<>("Courses added successfully", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>("Failed to add courses: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    @PutMapping("/course_edit")
    public Course editCourseDetails(@RequestBody Course updateCourse) {
        return courseService.editCourseDetails(updateCourse);
}
   /* @PutMapping("/course_remove/{courseId}")
    public ResponseEntity<String> removeCourseFromFaculty(@PathVariable int courseId) {
        try {
            courseService.removeCourseFromFaculty(courseId);;
            return ResponseEntity.ok("Faculty Removed successfully");
        } catch (Exception e) {
            // Handle exceptions, log errors, etc.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error removing faculty");
        }
    }*/

    @PutMapping("/removeCourses")
    public ResponseEntity<String> removeFacultyCourses(
            @RequestBody FacultyCourseRequest request) {

        try {
            courseService.removeFacultyCourses(request);
            return new ResponseEntity<>("Courses removed successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to remove courses: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
