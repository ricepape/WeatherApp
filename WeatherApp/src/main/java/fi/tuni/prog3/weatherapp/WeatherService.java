package fi.tuni.prog3.weatherapp;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WeatherService implements iAPI {
    @Override
    public List<String> lookUpLocation(String loc) {
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

    @Override
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

        @Override
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

}
