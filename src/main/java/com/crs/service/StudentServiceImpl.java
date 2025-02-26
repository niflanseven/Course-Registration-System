package main.java.com.crs.service;

import main.java.com.crs.dao.StudentDAO;
import main.java.com.crs.dao.DAOFactory;
import main.java.com.crs.entity.Student;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.STUDENT);

    @Override
    public boolean save(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public boolean update(Student student) {
        return studentDAO.update(student);
    }

    @Override
    public boolean delete(String studentId) {
        return studentDAO.delete(studentId);
    }

    @Override
    public Student findById(String studentId) {
        return studentDAO.findById(studentId);
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }
}