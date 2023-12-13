package fi.tuni.prog3.weatherapp;

import java.io.IOException;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WeatherGUI {

    private Label tempLabel;
    private Label temp_maxLabel;
    private Label temp_minLabel;
    private Label feels_likeLabel;
    private Label pressureLabel;
    private Label humidityLabel;
    private Label weather_descriptionLabel;
    private Label wind_speedLabel;
    private Label rain_intensityLabel;
    private Label errorLabel;
    private ImageView weatherImage;
    private ImageView titleImage;
    //private TextField location;
    
    
    public WeatherGUI(){
        
    }

    /**
     * Default constructor for WeatherView
     * @param tempLabel
     * @param temp_maxLabel
     * @param temp_minLabel
     * @param feels_likeLabel
     * @param pressureLabel
     * @param humidityLabel
     * @param weather_descriptionLabel
     * @param wind_speedLabel
     * @param errorLabel
     * @param rain_intensityLabel
     * @param weatherImage
     * @param titleImage
     */
    public WeatherGUI(Label tempLabel, Label temp_maxLabel, Label temp_minLabel,
            Label feels_likeLabel, Label pressureLabel, Label humidityLabel,
            Label weather_descriptionLabel, Label wind_speedLabel, Label errorLabel, 
            Label rain_intensityLabel, ImageView weatherImage,
            ImageView titleImage) {
        this.tempLabel = tempLabel;
        this.temp_maxLabel = temp_maxLabel;
        this.temp_minLabel = temp_minLabel;
        this.feels_likeLabel = feels_likeLabel;
        this.pressureLabel = pressureLabel;
        this.humidityLabel = humidityLabel;
        this.wind_speedLabel = wind_speedLabel;
        this.rain_intensityLabel = rain_intensityLabel;
        this.weather_descriptionLabel = weather_descriptionLabel;
        this.errorLabel = errorLabel;
        this.weatherImage = weatherImage;
        this.titleImage = titleImage;
        //this.location = location;
    }

    /**
     * Set temperatureLabel text
     *
     * @param temperature
     *
     */
    public void setTemperatureLabel(String temperature) {
        tempLabel.setText(temperature);
    }

    /**
     * Set maxTemperatureLabel text
     *
     * @param maxTemperature
     *
     */
    public void setMaxTemperatureLabel(String maxTemperature) {
        temp_maxLabel.setText(maxTemperature);
    }

    /**
     * Set minTemperatureLabel text
     *
     * @param minTemperature
     *
     */
    public void setMinTemperatureLabel(String minTemperature) {
        temp_minLabel.setText(minTemperature);
    }

    /**
     * Set feelsLikeLabel text
     *
     * @param feelsLike
     *
     */
    public void setFeelsLikeLabel(String feelsLike) {
        feels_likeLabel.setText(feelsLike);
    }

    /**
     * Set pressureLabel text
     *
     * @param pressure
     *
     */
    public void setPressureLabel(String pressure) {
        pressureLabel.setText(pressure);
    }

    /**
     * Set humidityLabel text
     *
     * @param humidity
     *
     */
    public void setHumidityLabel(String humidity) {
        humidityLabel.setText(humidity);
    }

    /**
     * Set weatherDescriptionLabel text
     *
     * @param description
     *
     */
    public void setWeatherDescriptionLabel(String description) {
        weather_descriptionLabel.setText(description);
    }
    
    /**
     * Set weatherDescriptionLabel text
     *
     * @param wind_speed
     *
     */
    public void setWindSpeedLabel(String wind_speed) {
        wind_speedLabel.setText(wind_speed);
    }
    
    /**
     * Set weatherDescriptionLabel text
     *
     * @param rain_intensity
     *
     */
    public void setRainIntensityLabel(String rain_intensity) {
       rain_intensityLabel.setText(rain_intensity);
    }

    /**
     * Set errorLabel text
     *
     * @param errorMessage
     *
     */
    public void setErrorLabel(String errorMessage) {
        errorLabel.setText(errorMessage);
    }

    /**
     * Set weatherImage image
     *
     * @param imageUrl
     *
     */
    public void setWeatherImage(String imageUrl) {
        Image weatherIconImage = new Image(imageUrl);
        weatherImage.setImage(weatherIconImage);
    }

    /**
     * Set titleImage image
     *
     * @param imageUrl
     *
     */
    public void setTitleImage(String imageUrl) {
        Image weatherIconImage = new Image(imageUrl);
        titleImage.setImage(weatherIconImage);
    }

    /**
     * Clear errorLabel text
     *
     * @throws java.io.IOException
     */
    public void ReturnToMain() throws IOException {
        App.setRoot("main");
    }
    
    
}