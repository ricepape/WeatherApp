package fi.tuni.prog3.weatherapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
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
    private AnchorPane anchorPane;

    @FXML
    private StackPane contentArea; // can be switched among forecast, history, maps. forecast is default.

    // Displaying hourly weather forecast
    @FXML
    private VBox forecastHourlyPane;
    @FXML
    private HBox forecastH1;
    @FXML
    private HBox forecastH2;
    @FXML
    private HBox forecastH3;
    @FXML
    private HBox forecastH4;
    @FXML
    private HBox forecastH5;
    @FXML
    private HBox forecastH6;
    @FXML
    private HBox forecastH7;

    private void loadFXML(String fileName) throws IOException {
        try {
            anchorPane.getChildren().clear();
            System.out.println("Loading " + fileName);
            FXMLLoader fxmlLoader = new FXMLLoader(WeatherApp.class.getResource(fileName));
            anchorPane.getChildren().add(fxmlLoader.load());
        } catch (IOException e){
            // Handle the exception.
        }
    }

    public void initialize() throws IOException {

        // set the default to forecastButton and load the corresponding fxml
        loadFXML("Main.fxml");

        //String displayedView;

    }

}
