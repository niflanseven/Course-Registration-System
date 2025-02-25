package main.java.com.crs.service;

import main.java.com.crs.dao.CourseDAO;
import main.java.com.crs.dao.DAOFactory;
import main.java.com.crs.dto.CourseDTO;

import java.util.List;


public class CourseServiceImpl implements CourseService {
    private CourseDAO courseDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.COURSE);

    @Override
    public boolean save(CourseDTO course) {
        return courseDAO.save(course);
    }

    @Override
    public boolean update(CourseDTO course) {
        return courseDAO.update(course);
    }

    @Override
    public boolean delete(int courseId) {
        return courseDAO.delete(courseId);
    }

    @Override
    public CourseDTO findById(int courseId) {
        return courseDAO.findById(courseId);
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseDAO.findAll();
    }
}
