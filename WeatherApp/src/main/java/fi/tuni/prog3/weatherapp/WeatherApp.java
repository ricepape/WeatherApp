package fi.tuni.prog3.weatherapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.fxml.FXMLLoader;

import java.io.File;


/**
 * JavaFX Sisu
 */
public class WeatherApp extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        
        // Load main FXML and set up scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Scene scene = new Scene(loader.load());

        // Get controller
        MainController controller = loader.getController();
        controller.getServices(
                new WeatherService(),
                new LocationService(),
                new FileHandler()
        );

        stage.setScene(scene);
        stage.setTitle("Weather App");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
