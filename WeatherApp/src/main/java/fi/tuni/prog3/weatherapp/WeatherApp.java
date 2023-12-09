package fi.tuni.prog3.weatherapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import javafx.fxml.FXMLLoader;

import java.io.IOException;


/**
 * JavaFX Sisu
 */
public class WeatherApp extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException{
        
        // Load main FXML and set up scene
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Scene scene = new Scene(loadFXML("main"));

        stage.setScene(scene);
        stage.setTitle("Weather App");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WeatherApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    /*
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
                response.append(line);
            }

            reader.close();

            // Parse the JSON response using JsonParser
            JsonParser parser = new JsonParser();
            JsonObject jsonResponse = parser.parse(response.toString()).getAsJsonObject();

            // Return the JsonObject
            // Return the JsonObject
            // Return the JSONObject
            return jsonResponse;

        } catch (IOException e) {
            // Handle exceptions, such as network errors
            return null;
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
    */
}