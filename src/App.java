import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resource = getClass().getResource("./main/java/resources/com/view/main.fxml");
        Parent root =FXMLLoader.load(resource);
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Course Registration System");
        primaryStage.show();
    }
   
}