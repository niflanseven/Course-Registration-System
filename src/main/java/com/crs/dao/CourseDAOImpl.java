package main.java.com.crs.dao;

import main.java.com.crs.entity.Course; // Use entity class
import main.java.com.crs.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public boolean save(Course course) { // Use entity class
        String query = "INSERT INTO Courses (course_id, title, credit_hours, department, prerequisites, max_capacity) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, course.getCourseId());
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
    public boolean update(Course course) { // Use entity class
        String query = "UPDATE Courses SET title = ?, credit_hours = ?, department = ?, prerequisites = ?, max_capacity = ? WHERE course_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, course.getTitle());
            stmt.setInt(2, course.getCreditHours());
            stmt.setString(3, course.getDepartment());
            stmt.setString(4, course.getPrerequisites());
            stmt.setInt(5, course.getMaxCapacity());
            stmt.setString(6, course.getCourseId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String courseId) {
        String query = "DELETE FROM Courses WHERE course_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, courseId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Course findById(String courseId) { // Use entity class
        String query = "SELECT * FROM Courses WHERE course_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, courseId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Course(
                        rs.getString("course_id"),
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
    public List<Course> findAll() { // Use entity class
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM Courses";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                courses.add(new Course(
                        rs.getString("course_id"),
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