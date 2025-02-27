package main.java.com.crs.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {
    @FXML
    private AnchorPane root;

    @FXML
    void btnCoursesOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/main/java/resources/com/view/course.fxml"))));
        stage.setTitle("Course Management System");
        stage.show();
    }

    @FXML
    void btnEnrollementsOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/main/java/resources/com/view/enrollment.fxml"))));
        stage.setTitle("Course Management System");
        stage.show();
    }

    @FXML
    void btnStudentsOnAction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/main/java/resources/com/view/student.fxml"))));
        stage.setTitle("Course Management System");
        stage.show();
    }
}
