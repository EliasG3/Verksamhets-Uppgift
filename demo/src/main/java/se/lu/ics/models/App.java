package se.lu.ics.models;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import java.net.URL;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        URL fxml = getClass().getResource("/fxml/MainView.fxml");
        FXMLLoader loader = new FXMLLoader(fxml);
        Scene scene = new Scene(loader.load());

        scene.getStylesheets().add(App.class.getResource("/css/light.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
