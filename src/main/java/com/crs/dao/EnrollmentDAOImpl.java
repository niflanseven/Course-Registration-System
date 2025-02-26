package main.java.com.crs.dao;

import main.java.com.crs.entity.Enrollment; // Use entity class
import main.java.com.crs.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAOImpl implements EnrollmentDAO {
    @Override
    public boolean save(Enrollment enrollment) { // Use entity class
        String query = "INSERT INTO Enrollments (enrollment_id, student_id, course_id, grade) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, enrollment.getEnrollmentId());
            stmt.setString(2, enrollment.getStudentId());
            stmt.setString(3, enrollment.getCourseId());
            stmt.setString(4, enrollment.getGrade());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Enrollment enrollment) { // Use entity class
        String query = "UPDATE Enrollments SET student_id = ?, course_id = ?, grade = ? WHERE enrollment_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, enrollment.getStudentId());
            stmt.setString(2, enrollment.getCourseId());
            stmt.setString(3, enrollment.getGrade());
            stmt.setString(4, enrollment.getEnrollmentId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String enrollmentId) {
        String query = "DELETE FROM Enrollments WHERE enrollment_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, enrollmentId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Enrollment findById(String enrollmentId) { // Use entity class
        String query = "SELECT * FROM Enrollments WHERE enrollment_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, enrollmentId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Enrollment(
                        rs.getString("enrollment_id"),
                        rs.getString("student_id"),
                        rs.getString("course_id"),
                        rs.getString("grade")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Enrollment> findAll() { // Use entity class
        List<Enrollment> enrollments = new ArrayList<>();
        String query = "SELECT * FROM Enrollments";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                enrollments.add(new Enrollment(
                        rs.getString("enrollment_id"),
                        rs.getString("student_id"),
                        rs.getString("course_id"),
                        rs.getString("grade")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollments;
    }
}