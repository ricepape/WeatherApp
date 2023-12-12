package fi.tuni.prog3.weatherapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ForecastController implements Initializable {

    @FXML
    private Label errorLabel;
    @FXML
    private ImageView titleImage;
    @FXML
    private TabPane forecastTabPane;

    private ForecastView forecastView;


    // Create a list for saving the data from the API
    private List<ForecastHourlyModel> forecastHourlyData;
    private List<Forecast5DaysModel> forecast5DaysModels;
    private List<Location> geoCodingData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
