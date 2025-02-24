CREATE DATABASE CRS;
USE CRS;

CREATE TABLE Courses (
    course_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    credit_hours INT NOT NULL,
    department VARCHAR(50),
    prerequisites VARCHAR(255),
    max_capacity INT NOT NULL
);

CREATE TABLE Students (
    student_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    date_of_birth DATE,
    program VARCHAR(50),
    year INT,
    contact_info VARCHAR(100)
);

CREATE TABLE Enrollments (
    enrollment_id INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT,
    course_id INT,
    grade VARCHAR(2),
    FOREIGN KEY (student_id) REFERENCES Students(student_id),
    FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);