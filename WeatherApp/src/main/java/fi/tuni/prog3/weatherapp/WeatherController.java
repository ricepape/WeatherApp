package fi.tuni.prog3.weatherapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    private Label feelsLikeLabel;
    @FXML
    private Label airQualityLabel;
    @FXML
    private Label rainIntensityLabel;
    @FXML
    private Label windSpeedLabel;
    @FXML
    private ImageView weatherImage;
    @FXML
    private ImageView titleImage;
    @FXML
    private TextField locationInput;

    private WeatherModel model;
    private WeatherView view;

    // Initialize the WeatherController
    public void initialize(URL location, ResourceBundle resources) {
        this.view = new WeatherView(temperatureLabel,maxTemperatureLabel,minTemperatureLabel,weatherImage, titleImage,
                locationInput,feelsLikeLabel,airQualityLabel,rainIntensityLabel,windSpeedLabel);
        this.view.setTitleImage("https://cdn2.iconfinder.com/data/icons/weather-flat-14/64/weather02-512.png");
    }

    // Get weather data from API
    public void getWeatherData(ActionEvent event) {
        // Get the location (lat and lon from input). If the inputs are acceptable, then get data
        String location = view.getLocationInput();


    }

    // Update the UI
    private void updateUI(WeatherModel model) {
        view.setTemperatureLabel(model.getTemperature() + "°C");
        view.setMaxTempLabel("H: " + model.getMaxTemp() + "°C");
        view.setMinTempLabel("L: " + model.getMinTemp() + "°C");
        view.setFeelsLikeLabel("Feels Like: " + model.getFeelsLike() + "°C");
        view.setRainIntensityLabel("Rain Intensity: " + model.getRainIntensity());
        view.setAirQualityLabel("Air Quality: " + model.getAirQuality());
        view.setWindSpeedLabel("Wind Speed: " + model.getWindSpeed());

        String iconCode = model.getIconCode();
        String iconUrl = "https://openweathermap.org/img/wn/" + iconCode + "@2x.png";
        // Load the image and set it in the view
        view.setWeatherImage(iconUrl);

    }
}
