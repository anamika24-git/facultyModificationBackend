package com.esd.project.faculty.faculty_modification.controller;

import java.util.List;

public class FacultyCourseRequest {

    private Long facultyId;
    private List<Long> courseIds;

    public Long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }

    public List<Long> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<Long> courseIds) {
        this.courseIds = courseIds;
    }
}
