CREATE DATABASE CRS;
USE CRS;

CREATE TABLE Courses (
    course_id VARCHAR(10) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    credit_hours INT NOT NULL,
    department VARCHAR(50),
    prerequisites VARCHAR(255),
    max_capacity INT NOT NULL
);

CREATE TABLE Students (
    student_id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    date_of_birth DATE,
    program VARCHAR(50),
    year INT,
    contact_info VARCHAR(100)
);

CREATE TABLE Enrollments (
    enrollment_id VARCHAR(10) PRIMARY KEY,
    student_id VARCHAR(10),
    course_id VARCHAR(10),
    grade VARCHAR(2),
    FOREIGN KEY (student_id) REFERENCES Students(student_id),
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);