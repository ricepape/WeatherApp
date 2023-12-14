package fi.tuni.prog3.weatherapp;

import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ForecastController {
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
    private TextField cityTextField;
    
    @FXML
    private TextField stateTextField;
    
    @FXML
    private TextField countryTextField;
    
    @FXML
    private Button searchButton;
    
    @FXML
    private Button returnButton;
    
    @FXML
    private VBox hourlyForecastVBox;
    
    @FXML
    private VBox dailyForecastVBox;
    
    @FXML
    private Label dtTxtLabel;
    
    public ForecastController(){
    }

    /**
     * Default constructor for WeatherController
     * @param tempLabel
     * @param temp_maxLabel
     * @param temp_minLabel
     * @param feels_likeLabel
     * @param pressureLabel
     * @param humidityLabel
     * @param weather_descriptionLabel
     * @param wind_speedLabel
     * @param rain_intensityLabel
     * @param weatherImage
     * @param titleImage
     */
    public ForecastController (Label tempLabel, Label temp_maxLabel, Label temp_minLabel,
            Label feels_likeLabel, Label pressureLabel, Label humidityLabel,
            Label weather_descriptionLabel, Label wind_speedLabel,
            Label rain_intensityLabel, ImageView weatherImage,
            ImageView titleImage, Label dtTxtLabel) {
        this.tempLabel = tempLabel;
        this.temp_maxLabel = temp_maxLabel;
        this.temp_minLabel = temp_minLabel;
        this.feels_likeLabel = feels_likeLabel;
        this.pressureLabel = pressureLabel;
        this.humidityLabel = humidityLabel;
        this.wind_speedLabel = wind_speedLabel;
        this.rain_intensityLabel = rain_intensityLabel;
        this.weather_descriptionLabel = weather_descriptionLabel;
        this.weatherImage = weatherImage;
        this.titleImage = titleImage;
        this.dtTxtLabel = dtTxtLabel;
    }
    

    public void clearErrorLabel() {
        errorLabel.setText("");
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
    
        LocationModel locationModel = model.get(0);
        List<ForecastModel> forecastModels = readAPI.getForecast(locationModel.getLatitude(), locationModel.getLongitude());
        for (ForecastModel forecastModel: forecastModels){
            ForecastController forecastController = new ForecastController();
            forecastController.tempLabel.setText("Temperature: " + forecastModel.getTemperature() + "°F");
            forecastController.temp_maxLabel.setText("Max temperature: " + forecastModel.getMaxTemperature() + "°F");
            forecastController.temp_minLabel.setText("Min temperature: " + forecastModel.getMinTemperature() + "°F");
            forecastController.feels_likeLabel.setText("Feels like: " + forecastModel.getFeelsLike() + "°F");
            forecastController.pressureLabel.setText("Pressure: " + forecastModel.getPressure());
            forecastController.humidityLabel.setText("Humidity: " + forecastModel.getHumidity() + "%");
            forecastController.wind_speedLabel.setText(": " + forecastModel.getWindSpeed() + "%");
            Image weatherIconImage = new Image("https://openweathermap.org/img/wn/" + forecastModel.getIconCode() + "@2x.png");
            forecastController.weatherImage.setImage(weatherIconImage);
            forecastController.weather_descriptionLabel.setText(forecastModel.getWeatherDescription());
            forecastController.dtTxtLabel.setText(forecastModel.getDtTxt());
            forecastController.rain_intensityLabel.setText("Rain intensity: " + forecastModel.getRainIntensity());
            hourlyForecastVBox.getChildren().add(forecastController);
        }
    }
}