/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



/**
 *
 * @author vudinhthi2304
 */
public class ReadAPI {
    private static final String API_KEY = "17bd51fb7bb76a6427811ec042b35080";
    
    /**
     * @param url
     * @return request
     */
    public static HttpRequest createHttpRequest(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        return request;
    }
    
    /**
     * Returns coordinates for a location.
     * @param loc Name of the location for which coordinates should be fetched.
     * @return String.
     */
    public List<LocationModel> lookUpLocation(String loc){
        String apiUrl = String.format("http://api.openweathermap.org/geo/1.0/direct?q=%s&appid=%s", loc, API_KEY);
        HttpRequest request = createHttpRequest(apiUrl);

        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return Location.fetchLocationData(response);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();  // Handle the exception appropriately
        }
        return null;
    }

    public WeatherModel getCurrentWeather(double lat, double lon){
        String apiUrl = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&appid=%s", lat, lon, API_KEY);
        HttpRequest request = createHttpRequest(apiUrl);

        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return Weather.fetchWeatherData(response);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();  // Handle the exception appropriately
        }
        return null;
    }

    public List<ForecastModel> getForecast(double lat, double lon){
        String apiUrl = String.format("https://api.openweathermap.org/data/2.5/forecast.hourly?lat=%f&lon=%f&appid=%s", lat, lon, API_KEY);
        HttpRequest request = createHttpRequest(apiUrl);

        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return Forecast.fetchForecastData(response);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();  // Handle the exception appropriately
        }

        return null;
    }
}

