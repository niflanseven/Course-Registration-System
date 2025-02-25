package main.java.com.crs.service;

import main.java.com.crs.dto.CourseDTO;
import java.util.List;

public interface CourseService {
    boolean saveCourse(CourseDTO course);
    boolean updateCourse(CourseDTO course);
    boolean deleteCourse(int courseId);
    CourseDTO findCourseById(int courseId);
    List<CourseDTO> findAllCourses();
}
