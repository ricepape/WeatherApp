package fi.tuni.prog3.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WeatherView {

    private final Label temperatureLabel;
    private final Label maxTempLabel;
    private Label minTempLabel;
    private ImageView weatherImage;
    private ImageView titleImage;
    private TextField locationInput;
    private Label feelsLikeLabel;
    private Label airQualityLabel;
    private Label rainIntensityLabel;
    private Label windSpeedLabel;
    private Label errorLabel;
    //private TextField latitudeInput;
    //private TextField longitudeInput;

    // Default constructor
    public WeatherView(Label temperatureLabel, Label maxTempLabel, Label minTempLabel, ImageView weatherImage, ImageView titleImage,
                       TextField locationInput, Label feelsLikeLabel, Label airQualityLabel, Label rainIntensityLabel,
                       Label windSpeedLabel, Label errorLabel) {
        this.temperatureLabel = temperatureLabel;
        this.maxTempLabel = maxTempLabel;
        this.minTempLabel = minTempLabel;
        this.weatherImage =weatherImage;
        this.titleImage = titleImage;
        this.locationInput = locationInput;
        this.feelsLikeLabel = feelsLikeLabel;
        this.airQualityLabel = airQualityLabel;
        this.rainIntensityLabel = rainIntensityLabel;
        this.windSpeedLabel = windSpeedLabel;
        this.errorLabel = errorLabel;
        
        //this.latitudeInput = latitudeInput;
        //this.longitudeInput = longitudeInput;
    }

    // Set temperature label
    public void setTemperatureLabel(String temperature) {
        temperatureLabel.setText(temperature);
    }

    // Set maxTempLabel
    public void setMaxTempLabel(String maxTemp) {
        maxTempLabel.setText(maxTemp);
    }

    // Set minTempLabel
    public void setMinTempLabel(String minTemp) {
        minTempLabel.setText(minTemp);
    }
    public void setFeelsLikeLabel(String feelsLike) {feelsLikeLabel.setText(feelsLike);}
    public void setAirQualityLabel(String airQuality) {airQualityLabel.setText(airQuality);}
    public void setRainIntensityLabel(String rainIntensity) {rainIntensityLabel.setText(rainIntensity);}
    public void setWindSpeedLabel(String windSpeed) {windSpeedLabel.setText(windSpeed);}

    public void setWeatherImage(String imageUrl) {
        Image weatherIconImage = new Image(imageUrl);
        weatherImage.setImage(weatherIconImage);
    }

    public void setTitleImage(String imageUrl) {
        Image weatherIconImage = new Image(imageUrl);
        titleImage.setImage(weatherIconImage);
    }

    public void setErrorLabel(String error) {
        errorLabel.setText(error);
    }

    public void clearErrorLabel() {
    }
}
