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
        String query = "INSERT INTO Courses (title, credit_hours, department, prerequisites, max_capacity) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, course.getTitle());
            stmt.setInt(2, course.getCreditHours());
            stmt.setString(3, course.getDepartment());
            stmt.setString(4, course.getPrerequisites());
            stmt.setInt(5, course.getMaxCapacity());
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
            stmt.setInt(6, course.getCourseId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int courseId) {
        String query = "DELETE FROM Courses WHERE course_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, courseId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public CourseDTO findById(int courseId) {
        String query = "SELECT * FROM Courses WHERE course_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new CourseDTO(
                        rs.getInt("course_id"),
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
                        rs.getInt("course_id"),
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