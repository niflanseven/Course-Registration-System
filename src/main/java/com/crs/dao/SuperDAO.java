package main.java.com.crs.dao;

import java.util.List;

import main.java.com.crs.dto.CourseDTO;

public interface SuperDAO<T> {
    boolean save(CourseDTO course);
    boolean update(CourseDTO course);
    boolean delete(int courseId);
    CourseDTO findById(int courseId);
    List<CourseDTO> findAll();
}
