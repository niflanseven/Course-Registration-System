package main.java.com.crs.controller;

import main.java.com.crs.entity.Course; // Use entity class
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
    private TableView<Course> courseTable;
    @FXML
    private TableColumn<Course, String> courseIdColumn;
    @FXML
    private TableColumn<Course, String> courseTitleColumn;
    @FXML
    private TableColumn<Course, Integer> creditHoursColumn;
    @FXML
    private TableColumn<Course, String> departmentColumn;
    @FXML
    private TableColumn<Course, String> prerequisitesColumn;
    @FXML
    private TableColumn<Course, Integer> maxCapacityColumn;

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
    private ObservableList<Course> courseList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Bind TableView columns to Course properties
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
        List<Course> courses = courseService.findAll();
        courseList.setAll(courses);
        courseTable.setItems(courseList);
    }

    @FXML
    private void btnAddOnAction() {
        Course course = new Course();
        course.setCourseId(courseIdField.getText());
        course.setTitle(titleField.getText());
        course.setCreditHours(Integer.parseInt(creditHoursField.getText()));
        course.setDepartment(departmentField.getText());
        course.setPrerequisites(prerequisitesField.getText());
        course.setMaxCapacity(Integer.parseInt(maxCapacityField.getText()));

        courseService.save(course);
        loadCourses();
        clearFields();
    }

    @FXML
    private void btnUpdateOnAction() {
        Course selectedCourse = courseTable.getSelectionModel().getSelectedItem();
        if (selectedCourse != null) {
            selectedCourse.setCourseId(courseIdField.getText());
            selectedCourse.setTitle(titleField.getText());
            selectedCourse.setCreditHours(Integer.parseInt(creditHoursField.getText()));
            selectedCourse.setDepartment(departmentField.getText());
            selectedCourse.setPrerequisites(prerequisitesField.getText());
            selectedCourse.setMaxCapacity(Integer.parseInt(maxCapacityField.getText()));

            courseService.update(selectedCourse);
            loadCourses();
            clearFields();
        }
    }

    @FXML
    private void btnDeleteOnAction() {
        Course selectedCourse = courseTable.getSelectionModel().getSelectedItem();
        if (selectedCourse != null) {
            courseService.delete(selectedCourse.getCourseId());
            loadCourses();
            clearFields();
        }
    }

    private void populateInputFields(Course course) {
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