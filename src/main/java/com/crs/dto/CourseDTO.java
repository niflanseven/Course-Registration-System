package main.java.com.crs.dto;

public class CourseDTO {
    private int courseId;
    private String title;
    private int creditHours;
    private String department;
    private String prerequisites;
    private int maxCapacity;

    // Default Constructor
    public CourseDTO() {}

    // Parameterized Constructor
    public CourseDTO(int courseId, String title, int creditHours, String department, String prerequisites, int maxCapacity) {
        this.courseId = courseId;
        this.title = title;
        this.creditHours = creditHours;
        this.department = department;
        this.prerequisites = prerequisites;
        this.maxCapacity = maxCapacity;
    }

    // Getters and Setters
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", creditHours=" + creditHours +
                ", department='" + department + '\'' +
                ", prerequisites='" + prerequisites + '\'' +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}
