package fi.tuni.prog3.weatherapp;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import static fi.tuni.prog3.weatherapp.MainController.*;

public class WeatherController implements Initializable{

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
    private ImageView titleImage;
    @FXML
    private Label searchLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label stateLabel;
    @FXML
    private Label countryLabel;

    @FXML
    private Button searchButton;
    @FXML
    private Button returnButton;

    @FXML
    private AnchorPane content;
    private WeatherGUI view;
    private WeatherModel model;

    @FXML
    public void clearErrorLabel() {
        errorLabel.setText("");
    }

    @FXML
    public void returnToMain() throws IOException {
        App.setRoot("main");
    }

    @FXML
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

    @FXML
    private void updateUI(WeatherModel model) {
        cityLabel.setText(cityTextField.getText());
        tempLabel.setText("Temperature: " + model.getTemperature() + "°F");
        temp_maxLabel.setText("Max temperature: " + model.getMaxTemperature() + "°F");
        temp_minLabel.setText("Min temperature: " + model.getMinTemperature() + "°F");
        feels_likeLabel.setText("Feels like: " + model.getFeelsLike() + "°F");
        pressureLabel.setText("Pressure: " + model.getPressure());
        humidityLabel.setText("Humidity: " + model.getHumidity() + "%");
        wind_speedLabel.setText("Wind speed: " + model.getWindSpeed() + "%");
        rain_intensityLabel.setText("Rain Intensity: " + model.getRainIntensity() + "%");
        Image weatherIconImage = new Image("https://openweathermap.org/img/wn/" + model.getIconCode() + "@2x.png");
        weatherImage.setImage(weatherIconImage);
        weather_descriptionLabel.setText(model.getWeatherDescription());
    }

    @FXML
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.view = new WeatherGUI(tempLabel,temp_maxLabel,temp_minLabel,feels_likeLabel,pressureLabel,humidityLabel,weather_descriptionLabel,wind_speedLabel,errorLabel,rain_intensityLabel,weatherImage,titleImage);
        Search();
    }
}