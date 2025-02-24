package main.java.com.crs.service;

import java.util.List;

import main.java.com.crs.entity.Course;

public interface CourseService {
    List<Course> getAllCourses();
    void addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(int courseId);
}
