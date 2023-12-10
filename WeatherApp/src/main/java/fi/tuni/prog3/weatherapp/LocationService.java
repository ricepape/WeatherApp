package fi.tuni.prog3.weatherapp;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LocationService {
    private static final String LAST_LOCATION_FILE = "last_location.txt";

    public static Location getLastLocation() {
        return new Location("Tampere","Finland",612956.80,234713.63);
    }

    public void saveLastLocation(Location location) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LAST_LOCATION_FILE))) {
            // Save location in the format "Lat,Lon"
            writer.write(location.getLat() + "," + location.getLon());
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    public JsonObject getCurrentWeather(double lat, double lon) {
        try {
            String API_KEY = "Replace with API key";

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

            // Return the JsonObject
            // Return the JsonObject
            // Return the JSONObject
            return parser.parse(response.toString()).getAsJsonObject();

        } catch (IOException e) {
            // Handle exceptions, such as network errors
            return null;
        }
    }

    public String lookUpLocation(String loc){
        try {
            String API_KEY = "Replace with API key";

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
