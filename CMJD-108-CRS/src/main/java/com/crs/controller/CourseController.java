package main.java.com.crs.controller;

import main.java.com.crs.entity.Course;
import main.java.com.crs.service.CourseService;
import main.java.com.crs.service.CourseServiceImpl;
import java.util.List;

public class CourseController {
    private CourseService courseService = new CourseServiceImpl();

    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    public void addCourse(Course course) {
        courseService.addCourse(course);
    }

    public void updateCourse(Course course) {
        courseService.updateCourse(course);
    }

    public void deleteCourse(int courseId) {
        courseService.deleteCourse(courseId);
    }
}
