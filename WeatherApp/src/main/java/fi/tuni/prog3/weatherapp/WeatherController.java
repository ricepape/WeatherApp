package fi.tuni.prog3.weatherapp;

import java.io.IOException;
import javafx.fxml.FXML;

public class WeatherController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}