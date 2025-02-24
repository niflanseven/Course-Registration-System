package main.java.com.crs.service;

import java.sql.SQLException;
import java.util.List;

import main.java.com.crs.entity.Course;
import main.java.com.crs.dao.CourseDAO;
import main.java.com.crs.dao.CourseDAOImpl;

public class CourseServiceImpl implements CourseService {
    private CourseDAO courseDAO = new CourseDAOImpl();

    @Override
    public List<Course> getAllCourses() {
        try {
            return courseDAO.getAllCourses();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addCourse(Course course) {
        try {
            courseDAO.addCourse(course);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCourse(Course course) {
        try {
            courseDAO.updateCourse(course);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourse(int courseId) {
        try {
            courseDAO.deleteCourse(courseId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
