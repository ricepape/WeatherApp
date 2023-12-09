package fi.tuni.prog3.weatherapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class WeatherController {

    @FXML
    private Label temperatureLabel;
    @FXML
    private Label maxTemperatureLabel;
    @FXML
    private Label minTemperatureLabel;
    @FXML
    private ImageView weatherImage;

    private WeatherModel model;
    private WeatherView view;

    // Initialize the WeatherController
    public void initialize(URL location, ResourceBundle resources) {
        this.view = new WeatherView(temperatureLabel,maxTemperatureLabel,minTemperatureLabel,weatherImage);
    }

    // Get weather data from API
    public void getWeatherData(ActionEvent event) {
        // Get the location (lat and lon from input). If the inputs are acceptable, then get data

    }

    // Update the UI
    private void updateUI(WeatherModel model) {
        view.setTemperatureLabel(model.getTemperature() + "°C");
        view.setMaxTempLabel("H: " + model.getMaxTemp() + "°C");
        view.setMinTempLabel("L: " + model.getMinTemp() + "°C");
        String iconCode = model.getIconCode();
        String iconUrl = "sunny.png";

        view.setWeatherImage(iconUrl);

    }
}
