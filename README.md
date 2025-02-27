## Course Registration System (CRS)

The Course Registration System (CRS) is a JavaFX-based application designed to automate the course registration process for educational institutions. It allows students to manage their academic schedules and enables faculty and administrative staff to maintain and track course and student data.

# Table of Contents

    1.System Requirements

    2.Setup Instructions

        1.Prerequisites

        2.Database Setup

        3.Running the Application

    3.User Guide

        1.Course Management

        2.Student Management

        3.Enrollment Management

# System Requirements

    # Java Development Kit (JDK): Version 11 or higher.
    # JavaFX SDK: Version 17 or higher.
    # MySQL: Version 8.0 or higher.
    # IDE: IntelliJ IDEA, Eclipse, or Visual Studio Code (recommended).
    # MySQL Connector/J: JDBC driver for MySQL.

# Setup Instructions
    ## Prerequisites
        1.Install JDK:
            # Download and install the latest JDK from Oracle.
            # Set the JAVA_HOME environment variable.

        2.Install JavaFX SDK:
            # Download the JavaFX SDK from Gluon.
            # Extract the SDK to a folder (e.g., C:\javafx-sdk-17).

        3.Install MySQL:
            # Download and install MySQL from MySQL.
            # Set up a MySQL user with the necessary permissions.

        4.Download MySQL Connector/J:
            # Download the MySQL JDBC driver from MySQL Connector/J.
            # Add the .jar file to your project's lib folder.

    ## Database Setup
        # Database created methods and sample datas' in: database/scripts/crs_dump.sql

    ## Running the Application
        1.Clone the Repository:
            git clone https://github.com/your-username/Course-Registration-System.git
            cd Course-Registration-System

        2. Configure the Database Connection:

            # Open the DatabaseConnection.java file and update the database URL, username, and password:
                private static final String URL = "jdbc:mysql://localhost:3306/CRS";
                private static final String USER = "root";
                private static final String PASSWORD = "your_password";

        3. Add JavaFX and MySQL Libraries:
            Add the JavaFX SDK .jar files and the MySQL Connector/J .jar file to your project's lib folder.
            Configure your IDE to include these libraries in the classpath.

        4. Run the Application:
            Open the MainApp.java file and run it.
            The JavaFX application will launch, and you can start using the CRS.

## User Guide
    ## Course Management

        # Add a Course:
            Enter the course details (Course ID, Title, Credit Hours, Department, Prerequisites, Max Capacity) and click Add.

        # Update a Course:
            Select a course from the table, modify the details, and click Update.

        # Delete a Course:
            Select a course from the table and click Delete.

    ## Student Management

        # Add a Student:
            Enter the student details (Student ID, Name, Date of Birth, Program, Year, Contact Info) and click Add.

        # Update a Student:
            Select a student from the table, modify the details, and click Update.

        # Delete a Student:
            Select a student from the table and click Delete.

    ## Enrollment Management

        # Enroll a Student:
            Enter the enrollment details (Enrollment ID, Student ID, Course ID, Grade) and click Add.

        # Update an Enrollment:
            Select an enrollment from the table, modify the details, and click Update.

        # Delete an Enrollment:
            Select an enrollment from the table and click Delete.