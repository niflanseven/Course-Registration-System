package main.java.com.crs.dao;

import java.sql.SQLException;
import java.util.List;

import main.java.com.crs.entity.Course;

public interface CourseDAO {
    List<Course> getAllCourses() throws SQLException;
    void addCourse(Course course) throws SQLException;
    void updateCourse(Course course) throws SQLException;
    void deleteCourse(int courseId) throws SQLException;
}
