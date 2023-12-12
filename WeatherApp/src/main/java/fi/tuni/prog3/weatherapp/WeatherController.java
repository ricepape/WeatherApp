package fi.tuni.prog3.weatherapp;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WeatherController {

    @FXML
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
    private Label searchLabel;
    private Label cityLabel;
    private Label stateLabel;
    private Label countryLabel;
    private TextField cityTextField;
    private TextField stateTextField;
    private TextField countryTextField;
    private Button searchButton;
    private Button returnButton;

    public void clearErrorLabel() {
        errorLabel.setText("");
    }
    
    public void returnToMain() throws IOException {
        App.setRoot("main");
    }
    
    public void Search() {
        clearErrorLabel();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String country = countryTextField.getText();
    
        if ("".equals(city)) {
            errorLabel.setText("Please enter the city name");
            return;
        }
    
        ReadAPI readAPI = new ReadAPI();
        String search_string = city;
    
        if (!"".equals(state)) {
            search_string += "," + state;
        }
    
        if (!"".equals(country)) {
            search_string += "," + country;
        }
    
        List<LocationModel> model = readAPI.lookUpLocation(search_string);
    
        if (model.size() == 0) {
            errorLabel.setText("No results found");
            return;
        }
    
        LocationModel locationModel = model.get(0);
        WeatherModel weatherModel = readAPI.getCurrentWeather(locationModel.getLatitude(), locationModel.getLongitude());
        updateUI(weatherModel);
    }
    
    private void updateUI(WeatherModel model) {
        tempLabel.setText("Temperature: " + model.getTemperature() + "°F");
        temp_maxLabel.setText("Max temperature: " + model.getMaxTemperature() + "°F");
        temp_minLabel.setText("Min temperature: " + model.getMinTemperature() + "°F");
        feels_likeLabel.setText("Feels like: " + model.getFeelsLike() + "°F");
        pressureLabel.setText("Pressure: " + model.getPressure());
        humidityLabel.setText("Humidity: " + model.getHumidity() + "%");
        wind_speedLabel.setText("Humidity: " + model.getWindSpeed() + "%");
        rain_intensityLabel.setText("Humidity: " + model.getRainIntensity() + "%");
        Image weatherIconImage = new Image("https://openweathermap.org/img/wn/" + model.getIconCode() + "@2x.png");
        weatherImage.setImage(weatherIconImage);
        weather_descriptionLabel.setText(model.getWeatherDescription());
    }
    
    
    
    
    
    
    
    
}