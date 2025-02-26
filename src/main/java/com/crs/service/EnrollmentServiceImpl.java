package main.java.com.crs.service;

import main.java.com.crs.dao.EnrollmentDAO;
import main.java.com.crs.dao.DAOFactory;
import main.java.com.crs.entity.Enrollment; // Use entity class
import java.util.List;

public class EnrollmentServiceImpl implements EnrollmentService {
    private EnrollmentDAO enrollmentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.ENROLLMENT);

    @Override
    public boolean save(Enrollment enrollment) { // Use entity class
        return enrollmentDAO.save(enrollment);
    }

    @Override
    public boolean update(Enrollment enrollment) { // Use entity class
        return enrollmentDAO.update(enrollment);
    }

    @Override
    public boolean delete(String enrollmentId) {
        return enrollmentDAO.delete(enrollmentId);
    }

    @Override
    public Enrollment findById(String enrollmentId) { // Use entity class
        return enrollmentDAO.findById(enrollmentId);
    }

    @Override
    public List<Enrollment> findAll() { // Use entity class
        return enrollmentDAO.findAll();
    }
}