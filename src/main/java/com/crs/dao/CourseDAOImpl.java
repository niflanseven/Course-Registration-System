package main.java.com.crs.dao;

import main.java.com.crs.db.DatabaseConnection;
import main.java.com.crs.dto.CourseDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public boolean save(CourseDTO course) {
        String query = "INSERT INTO Courses (course_id, title, credit_hours, department, prerequisites, max_capacity) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, course.getCourseId()); // Set courseId as String
            stmt.setString(2, course.getTitle());
            stmt.setInt(3, course.getCreditHours());
            stmt.setString(4, course.getDepartment());
            stmt.setString(5, course.getPrerequisites());
            stmt.setInt(6, course.getMaxCapacity());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(CourseDTO course) {
        String query = "UPDATE Courses SET title = ?, credit_hours = ?, department = ?, prerequisites = ?, max_capacity = ? WHERE course_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, course.getTitle());
            stmt.setInt(2, course.getCreditHours());
            stmt.setString(3, course.getDepartment());
            stmt.setString(4, course.getPrerequisites());
            stmt.setInt(5, course.getMaxCapacity());
            stmt.setString(6, course.getCourseId()); // Set courseId as String
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String courseId) { // Change parameter type to String
        String query = "DELETE FROM Courses WHERE course_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, courseId); // Set courseId as String
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public CourseDTO findById(String courseId) { // Change parameter type to String
        String query = "SELECT * FROM Courses WHERE course_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, courseId); // Set courseId as String
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new CourseDTO(
                        rs.getString("course_id"), // Get courseId as String
                        rs.getString("title"),
                        rs.getInt("credit_hours"),
                        rs.getString("department"),
                        rs.getString("prerequisites"),
                        rs.getInt("max_capacity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CourseDTO> findAll() {
        List<CourseDTO> courses = new ArrayList<>();
        String query = "SELECT * FROM Courses";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                courses.add(new CourseDTO(
                        rs.getString("course_id"), // Get courseId as String
                        rs.getString("title"),
                        rs.getInt("credit_hours"),
                        rs.getString("department"),
                        rs.getString("prerequisites"),
                        rs.getInt("max_capacity")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}