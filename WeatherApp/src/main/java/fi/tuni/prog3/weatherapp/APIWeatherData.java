package fi.tuni.prog3.weatherapp;

import java.net.http.HttpResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

import com.google.gson.JsonParser;
import fi.tuni.prog3.weatherapp.WeatherModel;

public class APIWeatherData {
    public static WeatherModel fetchWeatherData(HttpResponse<String> response) {
        WeatherModel weatherModel = new WeatherModel();
        String responseBody = response.body();

        JsonObject json = JsonParser.parseString(responseBody).getAsJsonObject();

        double temp = json.getAsJsonObject("main").get("temp").getAsDouble();
        double temp_min = json.getAsJsonObject("main").get("temp_min").getAsDouble();
        double temp_max = json.getAsJsonObject("main").get("temp_max").getAsDouble();
        double feels_like = json.getAsJsonObject("main").get("feels_like").getAsDouble();
        double wind_speed = json.getAsJsonObject("main").get("wind_speed").getAsDouble();
        double rain_intensity = json.getAsJsonObject("main").get("rain_intensity").getAsDouble();
        String weatherDescription = json.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString()
                + " - " + json.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();
        String iconCode = json.getAsJsonArray("weather").get(0).getAsJsonObject().get("icon").getAsString();

        weatherModel = new WeatherModel(temp, temp_max, temp_min, iconCode, feels_like, rain_intensity, wind_speed, weatherDescription);

        return weatherModel;
    }
}
