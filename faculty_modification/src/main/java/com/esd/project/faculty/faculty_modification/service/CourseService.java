package com.esd.project.faculty.faculty_modification.service;

import com.esd.project.faculty.faculty_modification.controller.FacultyCourseRequest;
import com.esd.project.faculty.faculty_modification.entity.Course;

import java.util.List;

public interface CourseService {

    // get the available courses so get courses for  status == 1
    List<Course> getAvailableCourses();

    List<Course> getOfferedCourses(int facultyId);
    //course details can be edit by faculty return updated course details
 // void updatefacultyIDForCourse(int facultyId, int courseId);

    void addFacultyCourses(FacultyCourseRequest request);



    Course editCourseDetails(Course editCourse);

    //to get a particular course -> I can use it t check if course is present
    Course getCourseId(int courseId);

    //set employee_id of courseid table as null
   // void removeCourseFromFaculty (int courseId);

     void removeFacultyCourses(FacultyCourseRequest request);
}
