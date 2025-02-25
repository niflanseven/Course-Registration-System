package main.java.com.crs.controller;

import main.java.com.crs.dto.CourseDTO;
import main.java.com.crs.service.CourseService;
import main.java.com.crs.service.ServiceFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class CourseController {
    @FXML
    private TableView<CourseDTO> courseTable;
    @FXML
    private TableColumn<CourseDTO, String> courseIdColumn;
    @FXML
    private TableColumn<CourseDTO, String> courseTitleColumn;
    @FXML
    private TableColumn<CourseDTO, Integer> creditHoursColumn;
    @FXML
    private TableColumn<CourseDTO, String> departmentColumn;
    @FXML
    private TableColumn<CourseDTO, String> prerequisitesColumn;
    @FXML
    private TableColumn<CourseDTO, Integer> maxCapacityColumn;

    @FXML
    private TextField courseIdField;
    @FXML
    private TextField titleField;
    @FXML
    private TextField departmentField;
    @FXML
    private TextField maxCapacityField;
    @FXML
    private TextField creditHoursField;
    @FXML
    private TextField prerequisitesField;

    private CourseService courseService = ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.COURSE);
    private ObservableList<CourseDTO> courseList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Bind TableView columns to CourseDTO properties
        courseIdColumn.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        courseTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        creditHoursColumn.setCellValueFactory(new PropertyValueFactory<>("creditHours"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        prerequisitesColumn.setCellValueFactory(new PropertyValueFactory<>("prerequisites"));
        maxCapacityColumn.setCellValueFactory(new PropertyValueFactory<>("maxCapacity"));

        // Load data into TableView
        loadCourses();

        // Add a listener to the TableView to populate input fields when a row is selected
        courseTable.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    // Populate input fields with the selected course data
                    populateInputFields(newValue);
                }
            }
        );
    }

    private void loadCourses() {
        List<CourseDTO> courses = courseService.findAllCourses();
        courseList.setAll(courses);
        courseTable.setItems(courseList);
    }

    @FXML
    private void btnAddOnAction() {
        // Create a new CourseDTO object
        CourseDTO course = new CourseDTO();
        course.setCourseId(courseIdField.getText()); // Set the manually entered Course ID
        course.setTitle(titleField.getText());
        course.setCreditHours(Integer.parseInt(creditHoursField.getText()));
        course.setDepartment(departmentField.getText());
        course.setPrerequisites(prerequisitesField.getText());
        course.setMaxCapacity(Integer.parseInt(maxCapacityField.getText()));

        // Add the course to the database
        courseService.saveCourse(course);

        // Refresh the TableView
        loadCourses();

        // Clear input fields
        clearFields();
    }

    @FXML
    private void btnUpdateOnAction() {
        // Get the selected course from the TableView
        CourseDTO selectedCourse = courseTable.getSelectionModel().getSelectedItem();
        if (selectedCourse != null) {
            // Update the course details from the input fields
            selectedCourse.setCourseId(courseIdField.getText()); // Update the Course ID
            selectedCourse.setTitle(titleField.getText());
            selectedCourse.setCreditHours(Integer.parseInt(creditHoursField.getText()));
            selectedCourse.setDepartment(departmentField.getText());
            selectedCourse.setPrerequisites(prerequisitesField.getText());
            selectedCourse.setMaxCapacity(Integer.parseInt(maxCapacityField.getText()));

            // Update the course in the database
            courseService.updateCourse(selectedCourse);

            // Refresh the TableView
            loadCourses();

            // Clear input fields
            clearFields();
        }
    }

    @FXML
    private void btnDeleteOnAction() {
        // Get the selected course from the TableView
        CourseDTO selectedCourse = courseTable.getSelectionModel().getSelectedItem();
        if (selectedCourse != null) {
            // Delete the course from the database
            courseService.deleteCourse(selectedCourse.getCourseId()); // courseId is now a String
    
            // Refresh the TableView
            loadCourses();
    
            // Clear input fields
            clearFields();
        }
    }

    private void populateInputFields(CourseDTO course) {
        courseIdField.setText(course.getCourseId());
        titleField.setText(course.getTitle());
        creditHoursField.setText(String.valueOf(course.getCreditHours()));
        departmentField.setText(course.getDepartment());
        prerequisitesField.setText(course.getPrerequisites());
        maxCapacityField.setText(String.valueOf(course.getMaxCapacity()));
    }

    private void clearFields() {
        courseIdField.clear();
        titleField.clear();
        creditHoursField.clear();
        departmentField.clear();
        prerequisitesField.clear();
        maxCapacityField.clear();
    }
}