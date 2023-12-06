package fi.tuni.prog3.weatherappui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class PrimaryController {
    WeatherManager weatherManager;
    String locationSet;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    private ImageView img;
    @FXML
    private Button change,set, cancel;
    @FXML
    private Label location, temperature, day;

    // Constructor to set the initial city

    // Event handler for each button
    @FXML
    private void buttonHandler(javafx.event.ActionEvent ae) {

    }

    // Method to reset all fields
    private void reset() {
        bottomSet(false);
        day.setText;
        temperature.setText("");
        img.setImage(null);
    }

    // Method to set the new entered city

}
