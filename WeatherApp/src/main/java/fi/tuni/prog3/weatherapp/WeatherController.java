package fi.tuni.prog3.weatherapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import fi.tuni.prog3.weatherapp.APIWeatherData;
import fi.tuni.prog3.weatherapp.Function;
import javafx.fxml.Initializable;

import fi.tuni.prog3.weatherapp.LocationService;

public class WeatherController implements Initializable {

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
    @FXML
    private Label errorLabel;

    private WeatherModel model;
    private WeatherView view;
    private SearchView searchView;

    // Initialize the WeatherController
    public void initialize(URL location, ResourceBundle resources) {
        this.view = new WeatherView(temperatureLabel,maxTemperatureLabel,minTemperatureLabel,weatherImage, titleImage,
                locationInput,feelsLikeLabel,airQualityLabel,rainIntensityLabel,windSpeedLabel,errorLabel);
        this.view.setTitleImage("https://cdn2.iconfinder.com/data/icons/weather-flat-14/64/weather02-512.png");
    }

    // Get weather data from API
    public void getWeatherData(ActionEvent event) {
        // Get the location (lat and lon from input). If the inputs are acceptable, then get data
        String location = searchView.getLocationInput();

        //String loc = LocationService.lookUpLocation(location);

        String[] loc = location.split(",");
        String lat = loc[0];
        String lon = loc[1];

        // Check if lat or lon is empty

        // If not

        try {
            double latitudeValue = Double.parseDouble(lat);
            double longitudeValue = Double.parseDouble(lon);
            // check validity of values
            String apiKey = "cda257269cd8f052e74dc19afdd5252c";
            HttpRequest request = createHttpRequest("https://api.openweathermap.org/data/2.5/weather?lat="
                    + latitudeValue + "&lon=" + longitudeValue + "&APPID=" + apiKey);
            try {
                model = APIWeatherData.fetchWeatherData(HttpClient.newHttpClient().send((java.net.http.HttpRequest) request, HttpResponse.BodyHandlers.ofString()));
                view.clearErrorLabel();
                updateUI(model);
            } catch (IOException | InterruptedException e) {
                view.setErrorLabel("Can not fetch weather!");
            }
        } catch (NumberFormatException e) {
            errorLabel.setVisible(true);
            view.setErrorLabel("Latitude and longitude must be a number!");
        }

    }

    public void setErrorLabel(String errorMessage) {
        errorLabel.setText(errorMessage);
    }

    private HttpRequest createHttpRequest(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        return request;
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
