package fi.tuni.prog3.weatherapp;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MainController {

    @FXML
    private VBox mainVBox;
    
    @FXML
    private Label maintitleLabel;
    
    @FXML
    private Label maininformationLabel;
    
    @FXML
    private Button mainForecastButton;
    
    @FXML
    private Button mainWeatherButton;
    
    @FXML
    private Button mainQuitButton;
    
    @FXML
    private void SwitchToForecast() throws IOException {
        App.setRoot("forecast");
    }
    
    @FXML
    private void SwitchToWeather() throws IOException {
        App.setRoot("weather");
    }
    
    @FXML
    private void Quit() throws IOException {
        Platform.exit();
    }
    
}
    
    

