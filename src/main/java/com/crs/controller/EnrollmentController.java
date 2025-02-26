package main.java.com.crs.controller;

import main.java.com.crs.entity.Enrollment;
import main.java.com.crs.service.EnrollmentService;
import main.java.com.crs.service.ServiceFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class EnrollmentController {
    @FXML
    private TableView<Enrollment> enrollmentTable;
    @FXML
    private TableColumn<Enrollment, String> enrollmentIdColumn;
    @FXML
    private TableColumn<Enrollment, String> studentIdColumn;
    @FXML
    private TableColumn<Enrollment, String> courseIdColumn;
    @FXML
    private TableColumn<Enrollment, String> gradeColumn;

    @FXML
    private TextField enrollmentIdField;
    @FXML
    private TextField studentIdField;
    @FXML
    private TextField courseIdField;
    @FXML
    private TextField gradeField;

    private EnrollmentService enrollmentService = ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ENROLLMENT);
    private ObservableList<Enrollment> enrollmentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Bind TableView columns to Enrollment properties
        enrollmentIdColumn.setCellValueFactory(new PropertyValueFactory<>("enrollmentId"));
        studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        courseIdColumn.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));

        // Load data into TableView
        loadEnrollments();

        // Add a listener to the TableView to populate input fields when a row is selected
        enrollmentTable.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    // Populate input fields with the selected enrollment data
                    populateInputFields(newValue);
                }
            }
        );
    }

    private void loadEnrollments() {
        List<Enrollment> enrollments = enrollmentService.findAll();
        enrollmentList.setAll(enrollments);
        enrollmentTable.setItems(enrollmentList);
    }

    @FXML
    private void btnAddOnAction() {
        Enrollment enrollment = new Enrollment();
        enrollment.setEnrollmentId(enrollmentIdField.getText());
        enrollment.setStudentId(studentIdField.getText());
        enrollment.setCourseId(courseIdField.getText());
        enrollment.setGrade(gradeField.getText());

        enrollmentService.save(enrollment);
        loadEnrollments();
        clearFields();
    }

    @FXML
    private void btnUpdateOnAction() {
        Enrollment selectedEnrollment = enrollmentTable.getSelectionModel().getSelectedItem();
        if (selectedEnrollment != null) {
            selectedEnrollment.setEnrollmentId(enrollmentIdField.getText());
            selectedEnrollment.setStudentId(studentIdField.getText());
            selectedEnrollment.setCourseId(courseIdField.getText());
            selectedEnrollment.setGrade(gradeField.getText());

            enrollmentService.update(selectedEnrollment);
            loadEnrollments();
            clearFields();
        }
    }

    @FXML
    private void btnDeleteOnAction() {
        Enrollment selectedEnrollment = enrollmentTable.getSelectionModel().getSelectedItem();
        if (selectedEnrollment != null) {
            enrollmentService.delete(selectedEnrollment.getEnrollmentId());
            loadEnrollments();
            clearFields();
        }
    }

    private void populateInputFields(Enrollment enrollment) {
        enrollmentIdField.setText(enrollment.getEnrollmentId());
        studentIdField.setText(enrollment.getStudentId());
        courseIdField.setText(enrollment.getCourseId());
        gradeField.setText(enrollment.getGrade());
    }

    private void clearFields() {
        enrollmentIdField.clear();
        studentIdField.clear();
        courseIdField.clear();
        gradeField.clear();
    }
}
