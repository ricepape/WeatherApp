package fi.tuni.prog3.weatherapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class MainWindowController {

    @FXML
    private Button forecastButton;

    @FXML
    private Button searchButton;

    @FXML
    private Button historyButton;

    @FXML
    private Button mapsButton;

    @FXML
    private Button imperialButton;

    @FXML
    private StackPane contentArea;

    @FXML
    private HBox contentPane;

    @FXML
    private VBox mainPane; // displaying current weather, buttons, and 5 days forecast (default)

    @FXML
    private VBox forecastHourlyPane; // displaying hourly weather forecast

    private void loadFXML(String fileName) throws IOException {
        try {
            contentArea.getChildren().clear();
            System.out.println("Loading " + fileName);
            FXMLLoader fxmlLoader = new FXMLLoader(WeatherApp.class.getResource(fileName));
            contentArea.getChildren().add(fxmlLoader.load());
        } catch (IOException e){
            // Handle the exception.
        }
    }

    public void initialize() throws IOException {
        forecastButton.setUserData("forecastButton");
        searchButton.setUserData("searchButton");
        historyButton.setUserData("historyButton");
        mapsButton.setUserData("mapsButton");
        imperialButton.setUserData("imperialButton");

        // set the default to forecastButton and load the corresponding fxml
        loadFXML("main.fxml");
    }

}
