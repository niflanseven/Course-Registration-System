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

INSERT INTO Courses (course_id, title, credit_hours, department, prerequisites, max_capacity)
VALUES
('C101', 'Introduction to Computer Science', 3, 'Computer Science', NULL, 50),
('C102', 'Data Structures and Algorithms', 4, 'Computer Science', 'C101', 40),
('C103', 'Database Systems', 3, 'Computer Science', 'C101', 45),
('C104', 'Operating Systems', 4, 'Computer Science', 'C102', 35),
('C105', 'Software Engineering', 3, 'Computer Science', 'C102', 40),
('M201', 'Calculus I', 4, 'Mathematics', NULL, 60),
('M202', 'Linear Algebra', 3, 'Mathematics', 'M201', 50),
('P301', 'Classical Mechanics', 4, 'Physics', NULL, 30),
('P302', 'Quantum Physics', 4, 'Physics', 'P301', 25),
('E401', 'Introduction to Electronics', 3, 'Electrical Engineering', NULL, 40);

INSERT INTO Students (student_id, name, date_of_birth, program, year, contact_info)
VALUES
('S1001', 'John Doe', '2000-05-15', 'Computer Science', 2, 'john.doe@example.com'),
('S1002', 'Jane Smith', '2001-08-22', 'Mathematics', 1, 'jane.smith@example.com'),
('S1003', 'Alice Johnson', '1999-12-30', 'Physics', 3, 'alice.johnson@example.com'),
('S1004', 'Bob Brown', '2000-03-10', 'Electrical Engineering', 2, 'bob.brown@example.com'),
('S1005', 'Charlie Davis', '2001-07-18', 'Computer Science', 1, 'charlie.davis@example.com'),
('S1006', 'Eva Green', '2000-11-25', 'Mathematics', 2, 'eva.green@example.com'),
('S1007', 'Frank Wilson', '1999-09-05', 'Physics', 3, 'frank.wilson@example.com'),
('S1008', 'Grace Lee', '2001-02-14', 'Electrical Engineering', 1, 'grace.lee@example.com'),
('S1009', 'Henry Clark', '2000-06-20', 'Computer Science', 2, 'henry.clark@example.com'),
('S1010', 'Ivy Martinez', '2001-04-12', 'Mathematics', 1, 'ivy.martinez@example.com');

INSERT INTO Enrollments (enrollment_id, student_id, course_id, grade)
VALUES
('E1001', 'S1001', 'C101', 'A'),
('E1002', 'S1001', 'C102', 'B+'),
('E1003', 'S1002', 'M201', 'A-'),
('E1004', 'S1002', 'M202', 'B'),
('E1005', 'S1003', 'P301', 'A'),
('E1006', 'S1003', 'P302', 'B+'),
('E1007', 'S1004', 'E401', 'A-'),
('E1008', 'S1005', 'C101', 'B'),
('E1009', 'S1005', 'C103', 'A'),
('E1010', 'S1006', 'M201', 'B+'),
('E1011', 'S1006', 'M202', 'A-'),
('E1012', 'S1007', 'P301', 'A'),
('E1013', 'S1007', 'P302', 'B'),
('E1014', 'S1008', 'E401', 'A'),
('E1015', 'S1009', 'C101', 'B+'),
('E1016', 'S1009', 'C102', 'A-'),
('E1017', 'S1010', 'M201', 'A'),
('E1018', 'S1010', 'M202', 'B+');