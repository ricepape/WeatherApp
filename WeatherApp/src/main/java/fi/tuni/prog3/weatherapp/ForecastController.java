package fi.tuni.prog3.weatherapp;

import java.io.IOException;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ForecastController {
    @FXML
    private TableView<ForecastModel> hourlyForecastTable;
    @FXML
    private TableView<ForecastModel> dailyForecastTable;
    @FXML
    public TableColumn hourColumn;
    @FXML
    public TableColumn tempColumn;
    @FXML
    public TableColumn dateColumn;
    @FXML
    public TableColumn maxTempColumn;
    @FXML
    public TableColumn minTempColumn;
    @FXML
    public TableColumn feelsLikeColumn;
    @FXML
    public TableColumn humidityColumn;
    @FXML
    public TableColumn windSpeedColumn;
    
    @FXML
    private Label errorLabel;
    
    @FXML
    private ImageView weatherImage;
    
    @FXML
    private ImageView titleImage;
    
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
    
    public ForecastController(){
    }

    public ForecastController (TableView<ForecastModel> hourlyForecastTable, TableView<ForecastModel> dailyForecastTable,
                               TableColumn hourColumn, TableColumn tempColumn, TableColumn maxTempColumn,
                               TableColumn minTempColumn, TableColumn windSpeedColumn, TableColumn humidityColumn,
                               ImageView weatherImage, ImageView titleImage) {
        this.hourlyForecastTable = hourlyForecastTable;
        this.dailyForecastTable = dailyForecastTable;
        this.hourColumn = hourColumn;
        this.tempColumn = tempColumn;
        this.maxTempColumn = maxTempColumn;
        this.minTempColumn = minTempColumn;
        this.windSpeedColumn = windSpeedColumn;
        this.humidityColumn = humidityColumn;
        this.weatherImage = weatherImage;
        this.titleImage = titleImage;

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

        initialize();

        hourlyForecastTable.getColumns().addAll(hourColumn, tempColumn, humidityColumn, windSpeedColumn);
        dailyForecastTable.getColumns().addAll(dateColumn, maxTempColumn, minTempColumn);

        for (ForecastModel forecastModel: forecastModels){
            updateUI(forecastModel);
        }
    }
    
    private void updateUI(ForecastModel model) {
        // Update the tables
        hourlyForecastTable.getItems().add(model); // Add to hourly forecast table
        dailyForecastTable.getItems().add(model); // Add to daily forecast table
    }

    private void initialize() {
        // Initialize columns for forecast table
        TableColumn<ForecastModel, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDtTxt()));

        TableColumn<ForecastModel, Integer> hourColumn = new TableColumn<>("Hour");
        hourColumn.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getDt()).asObject());

        TableColumn<ForecastModel, String> tempColumn = new TableColumn<>("Temperature");
        tempColumn.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getTemperature())));

        TableColumn<ForecastModel, String> maxTempColumn = new TableColumn<>("Max Temperature");
        maxTempColumn.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getMaxTemperature())));

        TableColumn<ForecastModel, String> minTempColumn = new TableColumn<>("Min Temperature");
        minTempColumn.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getMinTemperature())));

        TableColumn<ForecastModel, String> feelsLikeTempColumn = new TableColumn<>("Feels Like Temperature");
        feelsLikeTempColumn.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getFeelsLike())));

        TableColumn<ForecastModel, String> humidityColumn = new TableColumn<>("Humidity");
        humidityColumn.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getHumidity())));

        TableColumn<ForecastModel, String> windSpeedColumn = new TableColumn<>("Wind Speed");
        windSpeedColumn.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getWindSpeed())));

    }
    
}