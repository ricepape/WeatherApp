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

    @FXML
    private Label temp_maxLabel;

    @FXML
    private Label temp_minLabel;

    @FXML
    private Label feels_likeLabel;

    @FXML
    private Label pressureLabel;

    @FXML
    private Label humidityLabel;

    @FXML
    private Label weather_descriptionLabel;

    @FXML
    private Label wind_speedLabel;

    @FXML
    private Label rain_intensityLabel;

    @FXML
    private Label errorLabel;

    @FXML
    private ImageView weatherImage;

    @FXML
    private Label titleLabel;

    @FXML
    private Button searchButton;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField stateTextField;

    @FXML
    private TextField countryTextField;

    public void clearErrorLabel() {
        errorLabel.setText("Search for the weather your favourite place here!");
    }
    
    public void returnToMain() throws IOException {
        App.setRoot("main");
    }
    
    public void Search() {
        clearErrorLabel();
        String in_city = cityTextField.getText();
        String in_state = stateTextField.getText();
        String in_country = countryTextField.getText();
        
        String city = in_city.replaceAll("\\s", "-");
        String state = in_state.replaceAll("\\s", "-");
        String country = in_country.replaceAll("\\s", "-");
    
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
            if (country.length() != 2){
                errorLabel.setText("Country must be entered with 2-digit code");
                return;
            }
            search_string += "," + country;
        }
    
        List<LocationModel> model = readAPI.lookUpLocation(search_string);
    
        if (model.isEmpty()) {
            errorLabel.setText("No results found");
            return;
        }

        titleLabel.setText(in_city);
    
        LocationModel locationModel = model.get(0);
        WeatherModel weatherModel = readAPI.getCurrentWeather(locationModel.getLatitude(), locationModel.getLongitude());
        updateUI(weatherModel);
    }
    
    private void updateUI(WeatherModel model) {
        tempLabel.setText(Math.floor((model.getTemperature()-273.15) * 100) / 100 + "°C");
        temp_maxLabel.setText("Max temperature: " + Math.floor((model.getMaxTemperature()-273.15) * 100) / 100 + "°C");
        temp_minLabel.setText("Min temperature: " + Math.floor((model.getMinTemperature()-273.15) * 100) / 100 + "°C");
        feels_likeLabel.setText("Feels like: " + Math.floor((model.getFeelsLike()-273.15) * 100) / 100 + "°C");
        pressureLabel.setText("Pressure: " + model.getPressure()+ "hPa");
        humidityLabel.setText("Humidity: " + model.getHumidity() + "%");
        wind_speedLabel.setText("Wind Speed: " + model.getWindSpeed() + "m/s");
        rain_intensityLabel.setText("Rain Intensity: " + model.getRainIntensity() + "mm");
        Image weatherIconImage = new Image("https://openweathermap.org/img/wn/" + model.getIconCode() + "@2x.png");
        weatherImage.setImage(weatherIconImage);
        weather_descriptionLabel.setText(model.getWeatherDescription());
    }
    
    
    
    
    
    
    
    
}