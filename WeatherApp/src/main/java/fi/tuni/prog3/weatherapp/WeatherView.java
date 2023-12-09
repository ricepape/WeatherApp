package fi.tuni.prog3.weatherapp;

import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WeatherView {

    private final Label temperatureLabel;
    private final Label maxTempLabel;
    private final Label minTempLabel;
    private final ImageView weatherImage;
    //private TextField location;

    // Maybe implementing search (textfield) and displaying other information

    // Default constructor
    public WeatherView(Label temperatureLabel, Label maxTempLabel, Label minTempLabel, ImageView weatherImage) {
        this.temperatureLabel = temperatureLabel;
        this.maxTempLabel = maxTempLabel;
        this.minTempLabel = minTempLabel;
        this.weatherImage =weatherImage;
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

    public void setWeatherImage(String imageUrl) {
        Image weatherIconImage = new Image(imageUrl);
        weatherImage.setImage(weatherIconImage);
    }
}
