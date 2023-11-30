package com.esd.project.faculty.faculty_modification.service;

import com.esd.project.faculty.faculty_modification.controller.FacultyCourseRequest;
import com.esd.project.faculty.faculty_modification.entity.Course;
import com.esd.project.faculty.faculty_modification.entity.Employee;
import com.esd.project.faculty.faculty_modification.repository.CourseRepository;
import com.esd.project.faculty.faculty_modification.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Course> getAvailableCourses() {
        return courseRepository.getAvailableCourses();
    }

    public List<Course> getOfferedCourses(int facultyId) {
        return courseRepository.getOfferedCourses(facultyId);
    }

    @Override
    public Course getCourseId(int courseId) {
        Optional<Course> result = courseRepository.findById(courseId);
       Course foundcourse = null;
        if(result.isPresent())
        {
            foundcourse = result.get();
        }
        else {
            throw new RuntimeException("Did not found employee id - " + courseId);
        }
        return foundcourse;
    }


  /* @Override
   @Transactional
    public void updatefacultyIDForCourse(int facultyId, int courseId) {

       System.out.println("Updating facultyId: " + facultyId + " for courseId: " + courseId);
       courseRepository.updateFacultyIdForCourse(facultyId, courseId);
       System.out.println("Update completed."); }*/

  @Transactional
  @Override
  public void addFacultyCourses(FacultyCourseRequest request) {
      Long facultyId = request.getFacultyId();
      List<Long> courseIds = request.getCourseIds();


      // Assign the new faculty ID to the selected courses
      for (Long courseId : courseIds) {
          courseRepository.addFacultyCourses(courseId , facultyId);

      }
  }

    @Override
    public Course editCourseDetails(Course editCourse) {
        return courseRepository.save(editCourse);
    }

   /* @Override
    @Transactional
    public void removeCourseFromFaculty(int courseId) {
         courseRepository.RemoveCourseFromFaculty(courseId);

    }*/
   @Transactional
   @Override
   public void removeFacultyCourses(FacultyCourseRequest request) {
       List<Long> courseIds = request.getCourseIds();


       // Assign the new faculty ID to the selected courses
       for (Long courseId : courseIds) {
           courseRepository.removeFacultyCourses(courseId);

       }
   }
}
