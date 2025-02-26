package main.java.com.crs.service;

import main.java.com.crs.dao.CourseDAO;
import main.java.com.crs.dao.DAOFactory;
import main.java.com.crs.entity.Course; // Use entity class
import java.util.List;

public class CourseServiceImpl implements CourseService {
    private CourseDAO courseDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.COURSE);

    @Override
    public boolean save(Course course) { // Use entity class
        return courseDAO.save(course);
    }

    @Override
    public boolean update(Course course) { // Use entity class
        return courseDAO.update(course);
    }

    @Override
    public boolean delete(String courseId) {
        return courseDAO.delete(courseId);
    }

    @Override
    public Course findById(String courseId) { // Use entity class
        return courseDAO.findById(courseId);
    }

    @Override
    public List<Course> findAll() { // Use entity class
        return courseDAO.findAll();
    }
}