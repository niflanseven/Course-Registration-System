package main.java.com.crs.dto;

public class EnrollmentDTO {
    private String enrollmentId; // Changed to String
    private String studentId;
    private String courseId;
    private String grade;

    // Default Constructor
    public EnrollmentDTO() {}

    // Parameterized Constructor
    public EnrollmentDTO(String enrollmentId, String studentId, String courseId, String grade) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    // Getters and Setters
    public String getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "EnrollmentDTO{" +
                "enrollmentId='" + enrollmentId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
