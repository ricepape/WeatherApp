package fi.tuni.prog3.weatherapp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;


/**
 * JavaFX 
 */
public class WeatherApp extends Application {
    
    private static final String API_KEY = "17bd51fb7bb76a6427811ec042b35080";

    @Override
    public void start(Stage stage) {
        
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
        
        Scene scene = new Scene(root, 500, 700);                      
        stage.setScene(scene);
        stage.setTitle("WeatherApp");
        stage.show();
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
    
    public String getCurrentWeather(double lat, double lon) {
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
            response.append(line);
        }

        reader.close();

        // Parse the JSON response using JsonParser
        JsonParser parser = new JsonParser();
        JsonObject jsonResponse = parser.parse(response.toString()).getAsJsonObject();

        // Extract specific information from the JSON response
        String weatherDescription = jsonResponse.getAsJsonArray("weather")
                .get(0).getAsJsonObject().get("description").getAsString();
        double temperature = jsonResponse.getAsJsonObject("main").get("temp").getAsDouble();

        // Return the formatted result
        return String.format("Weather: %s, Temperature: %.2f °C", weatherDescription, temperature);

    } catch (IOException e) {
        // Handle exceptions, such as network errors
        return "Error fetching weather data";
    }
    
    }
    public String lookUpLocation(String loc){
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
        StringBuilder result = new StringBuilder();
        for (JsonElement locationElement : jsonResponse) {
                JsonObject locationObject = locationElement.getAsJsonObject();
                String locationName = locationObject.get("name").getAsString();
                result.append(locationName).append("\n");
            }

            return result.toString();

    } catch (IOException e) {
        // Handle exceptions, such as network errors
        return "Error fetching weather data";
    }
    }  
    
    private List<String> searchHistory = new ArrayList<>();
    
    private void addToSearchHistory(String result) {
        searchHistory.add(result);
    }
    
    public List<String> getSearchHistory() {
        return searchHistory;
    }
    
    
}
    

    
