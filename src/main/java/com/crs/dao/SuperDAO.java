package main.java.com.crs.dao;

import java.util.List;

public interface SuperDAO<T> {
    boolean save(T entity);
    boolean update(T entity);
    boolean delete(String id);
    T findById(String id);
    List<T> findAll();
}
