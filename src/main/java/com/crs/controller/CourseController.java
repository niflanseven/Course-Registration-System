package main.java.com.crs.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CourseController {

    @FXML
    private Button addButton;

    @FXML
    private TableColumn<?, ?> courseIdColumn;

    @FXML
    private TableView<?> courseTable;

    @FXML
    private TableColumn<?, ?> courseTitleColumn;

    @FXML
    private TableColumn<?, ?> creditHoursColumn;

    @FXML
    private TextField creditHoursField;

    @FXML
    private Button deleteButton;

    @FXML
    private TableColumn<?, ?> departmentColumn;

    @FXML
    private TextField departmentField;

    @FXML
    private TableColumn<?, ?> maxCapacityColumn;

    @FXML
    private TextField maxCapacityField;

    @FXML
    private TableColumn<?, ?> prerequisitesColumn;

    @FXML
    private TextField prerequisitesField;

    @FXML
    private TextField titleField;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        System.out.println("Add Button is Working......");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        System.out.println("Delete Button is Working......");
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        System.out.println("Update Button is Working......");
    }

}
