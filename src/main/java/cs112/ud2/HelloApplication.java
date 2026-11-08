package cs112.ud2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/** Launches the High Card interface for Unit Deliverable 2. */
public class HelloApplication extends Application {
    /** Loads the FXML layout and displays the game window. */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 560, 460);
        stage.setTitle("High Card - Leo Zhang");
        stage.setScene(scene);
        stage.show();
    }

    /** Starts the JavaFX application. */
    public static void main(String[] args) {
        launch();
    }
}
