package main.java.com.crs.dao;

import java.util.List;

import main.java.com.crs.dto.CourseDTO;

public interface SuperDAO<T> {
    boolean save(CourseDTO course);
    boolean update(CourseDTO course);
    boolean delete(String courseId); // Change parameter type to String
    CourseDTO findById(String courseId); // Change parameter type to String
    List<CourseDTO> findAll();
}
