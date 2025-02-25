package main.java.com.crs.service;

import java.util.List;

public interface SuperService<T> {
    boolean save(T entity);
    boolean update(T entity);
    boolean delete(int id);
    T findById(int id);
    List<T> findAll();
}
