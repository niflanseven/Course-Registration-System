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
    private TableColumn<CourseDTO, Integer> courseIdColumn;
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
        List<CourseDTO> courses = courseService.findAll();
        courseList.setAll(courses);
        courseTable.setItems(courseList);
    }

    @FXML
    private void btnAddOnAction() {
        CourseDTO course = new CourseDTO();
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
        CourseDTO selectedCourse = courseTable.getSelectionModel().getSelectedItem();
        if (selectedCourse != null) {
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
        CourseDTO selectedCourse = courseTable.getSelectionModel().getSelectedItem();
        if (selectedCourse != null) {
            courseService.delete(selectedCourse.getCourseId());
            loadCourses();
            clearFields();
        }
    }

    private void populateInputFields(CourseDTO course) {
        titleField.setText(course.getTitle());
        creditHoursField.setText(String.valueOf(course.getCreditHours()));
        departmentField.setText(course.getDepartment());
        prerequisitesField.setText(course.getPrerequisites());
        maxCapacityField.setText(String.valueOf(course.getMaxCapacity()));
    }

    private void clearFields() {
        titleField.clear();
        creditHoursField.clear();
        departmentField.clear();
        prerequisitesField.clear();
        maxCapacityField.clear();
    }
}