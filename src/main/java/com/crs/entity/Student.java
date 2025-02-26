package main.java.com.crs.entity;

public class Student {
    private String studentId;
    private String name;
    private String dateOfBirth;
    private String program;
    private int year;
    private String contactInfo;

    // Default Constructor
    public Student() {}

    // Parameterized Constructor
    public Student(String studentId, String name, String dateOfBirth, String program, int year, String contactInfo) {
        this.studentId = studentId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.program = program;
        this.year = year;
        this.contactInfo = contactInfo;
    }

    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", program='" + program + '\'' +
                ", year=" + year +
                ", contactInfo='" + contactInfo + '\'' +
                '}';
    }
}
