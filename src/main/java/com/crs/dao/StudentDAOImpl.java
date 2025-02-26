package main.java.com.crs.dao;

import main.java.com.crs.entity.Student; // Use entity class
import main.java.com.crs.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean save(Student student) { // Use entity class
        String query = "INSERT INTO Students (student_id, name, date_of_birth, program, year, contact_info) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getStudentId());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getDateOfBirth());
            stmt.setString(4, student.getProgram());
            stmt.setInt(5, student.getYear());
            stmt.setString(6, student.getContactInfo());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Student student) { // Use entity class
        String query = "UPDATE Students SET name = ?, date_of_birth = ?, program = ?, year = ?, contact_info = ? WHERE student_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getDateOfBirth());
            stmt.setString(3, student.getProgram());
            stmt.setInt(4, student.getYear());
            stmt.setString(5, student.getContactInfo());
            stmt.setString(6, student.getStudentId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String studentId) {
        String query = "DELETE FROM Students WHERE student_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, studentId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Student findById(String studentId) { // Use entity class
        String query = "SELECT * FROM Students WHERE student_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, studentId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getString("student_id"),
                        rs.getString("name"),
                        rs.getString("date_of_birth"),
                        rs.getString("program"),
                        rs.getInt("year"),
                        rs.getString("contact_info")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> findAll() { // Use entity class
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM Students";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                students.add(new Student(
                        rs.getString("student_id"),
                        rs.getString("name"),
                        rs.getString("date_of_birth"),
                        rs.getString("program"),
                        rs.getInt("year"),
                        rs.getString("contact_info")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}