package main.java.com.crs.service;

import main.java.com.crs.dao.CourseDAO;
import main.java.com.crs.dao.DAOFactory;
import main.java.com.crs.dto.CourseDTO;

import java.util.List;


public class CourseServiceImpl implements CourseService {
    private CourseDAO courseDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.COURSE);

    @Override
    public boolean saveCourse(CourseDTO course) {
        return courseDAO.save(course);
    }

    @Override
    public boolean updateCourse(CourseDTO course) {
        return courseDAO.update(course);
    }

    @Override
    public boolean deleteCourse(String courseId) { // Change parameter type to String
        return courseDAO.delete(courseId);
    }

    @Override
    public CourseDTO findCourseById(String courseId) { // Change parameter type to String
        return courseDAO.findById(courseId);
    }

    @Override
    public List<CourseDTO> findAllCourses() {
        return courseDAO.findAll();
    }
}
