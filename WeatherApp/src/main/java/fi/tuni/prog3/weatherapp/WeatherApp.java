package fi.tuni.prog3.weatherapp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.ImageView;


/**
 * JavaFX Sisu
 */
public class WeatherApp extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        
        //Creating a new BorderPane.
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        
        //Adding HBox to the center of the BorderPane.
        root.setCenter(getCenterVBox());
        
        //Adding button to the BorderPane and aligning it to the right.
        var quitButton = getQuitButton();
        BorderPane.setMargin(quitButton, new Insets(10, 10, 0, 10));
        root.setBottom(quitButton);
        BorderPane.setAlignment(quitButton, Pos.TOP_RIGHT);
        
        var searchButton = createSearchButton();
        BorderPane.setMargin(searchButton, new Insets(10, 0, 0, 10));
        root.setBottom(searchButton);
        BorderPane.setAlignment(searchButton, Pos.TOP_RIGHT);
        
        Scene scene = new Scene(root, 500, 700);                      
        stage.setScene(scene);
        stage.setTitle("Weather App");
        stage.show();
        
        // Adding search functionality
        TextField searchField = new TextField();
        HBox searchBox = new HBox(searchField, searchButton);
        searchBox.setAlignment(Pos.CENTER);
        root.setTop(searchBox);



        // Display initial weather data
        displayWeatherData("Your_Default_Location");
    }

    public static void main(String[] args) {
        launch();
    }
    
    private VBox getCenterVBox() {
        //Creating an HBox.
        VBox centerHBox = new VBox(10);
        
        //Adding two VBox to the HBox.
        centerHBox.getChildren().addAll(getTopHBox(), getBottomHBox());
        
        return centerHBox;
    }
    
    private HBox getTopHBox() {
        //Creating a VBox for the left side.
        HBox leftHBox = new HBox();
        leftHBox.setPrefHeight(330);
        leftHBox.setStyle("-fx-background-color: #8fc6fd;");
        
        leftHBox.getChildren().add(new Label("Top Panel"));
        
        return leftHBox;
    }
    
    private HBox getBottomHBox() {
        //Creating a VBox for the right side.
        HBox rightHBox = new HBox();
        rightHBox.setPrefHeight(330);
        rightHBox.setStyle("-fx-background-color: #b1c2d4;");
        
        rightHBox.getChildren().add(new Label("Bottom Panel"));
        
        return rightHBox;
    }
    
    private Button getQuitButton() {
        //Creating a button.
        Button button = new Button("Quit");
        
        //Adding an event to the button to terminate the application.
        button.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
        
        return button;
    }

    private Button createSearchButton() {
    // Creating a button.
    Button button = new Button("Search");

    // Adding an event to the button to perform a search.
    button.setOnAction((ActionEvent event) -> {
        // Call the method responsible for handling the search functionality
        handleSearch();
    });

    return button;
    }

    public JsonObject getCurrentWeather(double lat, double lon) {
    try {
        // Construct the URL with the latitude, longitude, and API key
        String apiUrl = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%.2f&lon=%.2f&appid=%s", lat, lon, API_KEY);
        URL url = new URL(apiUrl);

        // Create the connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Read the response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            
        }

        reader.close();

        // Parse the JSON response using JsonParser
        JsonParser parser = new JsonParser();
        JsonObject jsonResponse = parser.parse(response.toString()).getAsJsonObject();

        // Return the JsonObject
        return jsonResponse;

    } catch (IOException e) {
        // Handle exceptions, such as network errors
        return null;
    }
}
    
    
    public List<String> lookUpLocation(String loc){
    try {
        // Construct the URL with the latitude, longitude, and API key
        String apiUrl = String.format("http://api.openweathermap.org/geo/1.0/direct?q=%s&appid=%s", loc, API_KEY);
        URL url = new URL(apiUrl);

        // Create the connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        StringBuilder response;
        try ( // Read the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        // Parse the JSON response using JsonParser
        JsonParser parser = new JsonParser();
        JsonArray jsonResponse = parser.parse(response.toString()).getAsJsonArray();
        List<String> result = new ArrayList<>();
        for (JsonElement locationElement : jsonResponse) {
                JsonObject locationObject = locationElement.getAsJsonObject();
                String locationName = locationObject.get("name").getAsString();
                result.add(locationName);
            }

            return result;

    } catch (IOException e) {
        // Handle exceptions, such as network errors
        return null;
    }
    }  
    
    private final List<String> searchHistory = new ArrayList<>();
    
    private void addToSearchHistory(String result) {
        searchHistory.add(result);
    }
    
    public List<String> getSearchHistory() {
        return searchHistory;
    }

    public JsonObject getForecast(double lat, double lon) {
    try {
        // Construct the URL with the latitude, longitude, and API key
        String apiUrl = String.format("api.openweathermap.org/data/2.5/forecast?lat=%.2f&lon=%.2f&exclude=current,minutely,hourly,alerts&appid=%s", lat, lon, API_KEY);
        URL url = new URL(apiUrl);

        // Create the connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        StringBuilder response;
        try ( // Read the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        // Parse the JSON response using JsonParser
        JsonParser parser = new JsonParser();
        JsonObject jsonResponse = parser.parse(response.toString()).getAsJsonObject();

        // Return the JsonObject
        return jsonResponse;

    } catch (IOException e) {
        return null;
    }
    }

    private void displayWeatherData(String location) {
        // Get location details
        addToSearchHistory(location);

        // Display location details
        Label locationLabel = new Label(location);
        getTopHBox().getChildren().set(0, locationLabel);

        // Get current weather
        JsonObject currentWeather = getCurrentWeatherByLocation(location);
        if (currentWeather != null) {
            // Extract and display relevant weather information
            double temperature = currentWeather.getAsJsonObject("main").get("temp").getAsDouble();
            Label temperatureLabel = new Label("Temperature: " + temperature + " °C");
            getBottomHBox().getChildren().set(0, temperatureLabel);

            // Use OpenWeatherMap icons
            String iconCode = currentWeather.getAsJsonArray("weather")
                    .get(0).getAsJsonObject().get("icon").getAsString();
            ImageView weatherIcon = new ImageView("http://openweathermap.org/img/w/" + iconCode + ".png");
            getBottomHBox().getChildren().add(weatherIcon);
        } else {
            // Handle error
            Label errorLabel = new Label("Error fetching weather data for " + location);
            getBottomHBox().getChildren().setAll(errorLabel);
        }
    }

    private JsonObject getCurrentWeatherByLocation(String location) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private List<String> handleSearch() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    
    
    
}
    

    
