package main.java.com.crs.controller;

import main.java.com.crs.entity.Student;
import main.java.com.crs.service.StudentService;
import main.java.com.crs.service.ServiceFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class StudentController {
    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, String> studentIdColumn;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, String> dateOfBirthColumn;
    @FXML
    private TableColumn<Student, String> programColumn;
    @FXML
    private TableColumn<Student, Integer> yearColumn;
    @FXML
    private TableColumn<Student, String> contactInfoColumn;

    @FXML
    private TextField studentIdField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField dateOfBirthField;
    @FXML
    private TextField programField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField contactInfoField;

    private StudentService studentService = ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.STUDENT);
    private ObservableList<Student> studentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Bind TableView columns to Student properties
        studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateOfBirthColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        programColumn.setCellValueFactory(new PropertyValueFactory<>("program"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        contactInfoColumn.setCellValueFactory(new PropertyValueFactory<>("contactInfo"));

        // Load data into TableView
        loadStudents();

        // Add a listener to the TableView to populate input fields when a row is selected
        studentTable.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    // Populate input fields with the selected student data
                    populateInputFields(newValue);
                }
            }
        );
    }

    private void loadStudents() {
        List<Student> students = studentService.findAll();
        studentList.setAll(students);
        studentTable.setItems(studentList);
    }

    @FXML
    private void btnAddOnAction() {
        Student student = new Student();
        student.setStudentId(studentIdField.getText());
        student.setName(nameField.getText());
        student.setDateOfBirth(dateOfBirthField.getText());
        student.setProgram(programField.getText());
        student.setYear(Integer.parseInt(yearField.getText()));
        student.setContactInfo(contactInfoField.getText());

        studentService.save(student);
        loadStudents();
        clearFields();
    }

    @FXML
    private void btnUpdateOnAction() {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            selectedStudent.setStudentId(studentIdField.getText());
            selectedStudent.setName(nameField.getText());
            selectedStudent.setDateOfBirth(dateOfBirthField.getText());
            selectedStudent.setProgram(programField.getText());
            selectedStudent.setYear(Integer.parseInt(yearField.getText()));
            selectedStudent.setContactInfo(contactInfoField.getText());

            studentService.update(selectedStudent);
            loadStudents();
            clearFields();
        }
    }

    @FXML
    private void btnDeleteOnAction() {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            studentService.delete(selectedStudent.getStudentId());
            loadStudents();
            clearFields();
        }
    }

    private void populateInputFields(Student student) {
        studentIdField.setText(student.getStudentId());
        nameField.setText(student.getName());
        dateOfBirthField.setText(student.getDateOfBirth());
        programField.setText(student.getProgram());
        yearField.setText(String.valueOf(student.getYear()));
        contactInfoField.setText(student.getContactInfo());
    }

    private void clearFields() {
        studentIdField.clear();
        nameField.clear();
        dateOfBirthField.clear();
        programField.clear();
        yearField.clear();
        contactInfoField.clear();
    }
}
