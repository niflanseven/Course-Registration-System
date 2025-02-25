package main.java.com.crs.service;

import java.util.List;

import main.java.com.crs.dto.CourseDTO;

public interface SuperService<T> {
    boolean saveCourse(CourseDTO course);
    boolean updateCourse(CourseDTO course);
    boolean deleteCourse(String courseId); // Change parameter type to String
    CourseDTO findCourseById(String courseId); // Change parameter type to String
    List<CourseDTO> findAllCourses();
}
