package main.java.com.crs.dao;

import main.java.com.crs.db.DatabaseConnection;
import main.java.com.crs.entity.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public List<Course> getAllCourses() throws SQLException {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM Courses";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("course_id"));
                course.setTitle(rs.getString("title"));
                course.setCreditHours(rs.getInt("credit_hours"));
                course.setDepartment(rs.getString("department"));
                course.setPrerequisites(rs.getString("prerequisites"));
                course.setMaxCapacity(rs.getInt("max_capacity"));
                courses.add(course);
            }
        }
        return courses;
    }

    @Override
    public void addCourse(Course course) throws SQLException {
        String query = "INSERT INTO Courses (title, credit_hours, department, prerequisites, max_capacity) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, course.getTitle());
            stmt.setInt(2, course.getCreditHours());
            stmt.setString(3, course.getDepartment());
            stmt.setString(4, course.getPrerequisites());
            stmt.setInt(5, course.getMaxCapacity());
            stmt.executeUpdate();
        }
    }

    @Override
    public void updateCourse(Course course) throws SQLException {
        String query = "UPDATE Courses SET title = ?, credit_hours = ?, department = ?, prerequisites = ?, max_capacity = ? WHERE course_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, course.getTitle());
            stmt.setInt(2, course.getCreditHours());
            stmt.setString(3, course.getDepartment());
            stmt.setString(4, course.getPrerequisites());
            stmt.setInt(5, course.getMaxCapacity());
            stmt.setInt(6, course.getCourseId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteCourse(int courseId) throws SQLException {
        String query = "DELETE FROM Courses WHERE course_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, courseId);
            stmt.executeUpdate();
        }
    }
}
