package main.java.com.crs.service;

import java.util.List;

public interface SuperService<T> {
    boolean save(T entity);
    boolean update(T entity);
    boolean delete(String id);
    T findById(String id);
    List<T> findAll();
}
