package fi.tuni.prog3.weatherapp;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.http.HttpResponse;
/**
 * author: Thi Vu, Anh Tran
 */
public class Weather {
    public static WeatherModel fetchWeatherData(HttpResponse<String> response) {
        WeatherModel weatherModel = new WeatherModel();
        String responseBody = response.body();

        // Parse the JSON response
        JsonObject json = JsonParser.parseString(responseBody).getAsJsonObject();

        double temp = json.getAsJsonObject("main").get("temp").getAsDouble();
        double temp_min = json.getAsJsonObject("main").get("temp_min").getAsDouble();
        double temp_max = json.getAsJsonObject("main").get("temp_max").getAsDouble();
        double feels_like = json.getAsJsonObject("main").get("feels_like").getAsDouble();
        double pressure = json.getAsJsonObject("main").get("pressure").getAsDouble();
        double humidity = json.getAsJsonObject("main").get("humidity").getAsDouble();
        double wind_speed = json.getAsJsonObject("wind").get("speed").getAsDouble();
        // Check if "rain" is present in the first entry
        double rain_intensity = 0.0; // Default value if "rain" is not present
        if (json.has("rain") && json.getAsJsonObject("rain").has("1h")) {
            rain_intensity = json.getAsJsonObject("rain").get("1h").getAsDouble();
        }
        JsonArray weatherArray = json.getAsJsonArray("weather");
        String weatherDescription = weatherArray.get(0).getAsJsonObject().get("main").getAsString()
                + " - " + weatherArray.get(0).getAsJsonObject().get("description").getAsString();
        String iconCode = "02d";
        if (weatherArray.get(0).getAsJsonObject().has("icon")) {
            iconCode = weatherArray.get(0).getAsJsonObject().get("icon").getAsString();
        }
        weatherModel = new WeatherModel(temp, temp_max, temp_min, feels_like, humidity, pressure, wind_speed, rain_intensity, weatherDescription,
                iconCode);

        return weatherModel;
    }
    
    
}