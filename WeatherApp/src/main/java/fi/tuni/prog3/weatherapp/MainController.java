package fi.tuni.prog3.weatherapp;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class MainController implements Initializable{

    @FXML
    private RadioButton mainForecastButton;
    
    @FXML
    private RadioButton mainWeatherButton;
    @FXML
    public static TextField cityTextField;
    @FXML
    public static TextField stateTextField;
    @FXML
    public static TextField countryTextField;
    @FXML
    private Button searchButton;
    @FXML
    private StackPane content;
    @FXML
    private HBox contentArea;
    @FXML
    private ToggleGroup toggleGroup;
    
    @FXML
    private Button mainQuitButton;
    
    @FXML
    private void SwitchToForecast () throws IOException {
        App.setRoot("forecast");
    }
    
    @FXML
    private void SwitchToWeather () throws IOException {
        App.setRoot("weather");
    }
    
    @FXML
    private void Quit() throws IOException {
        Platform.exit();
    }

    private void loadFXML(String fxmlFileName) {
        try {
            content.getChildren().clear();
            System.out.println("Loading " + fxmlFileName);
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxmlFileName));
            content.getChildren().add(fxmlLoader.load());
        } catch (IOException e) {
            // Handle or log the exception appropriately

        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        toggleGroup = new ToggleGroup();
        mainWeatherButton.setUserData("weatherButton");
        mainForecastButton.setUserData("forecastButton");
        mainForecastButton.setToggleGroup(toggleGroup);
        mainWeatherButton.setToggleGroup(toggleGroup);

        toggleGroup.selectToggle(mainWeatherButton);
        loadFXML("weather");

        mainQuitButton.setOnAction(event -> Platform.exit());

        searchButton.setOnAction(event -> {
            String value = toggleGroup.getSelectedToggle().getUserData().toString();
            switch (value) {
                case "weatherButton":
                    value = "weather";
                    break;
                case "forecastButton":
                    value = "forecast";
                    break;
                default:
                    break;
            }
            loadFXML(value);
        });
    }
}
    
    

