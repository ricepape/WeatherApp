package fi.tuni.prog3.weatherapp;

import java.util.List;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import fi.tuni.prog3.weatherapp.Location;

public class APIGeoCodingData {
    public static List<Location> fetchGeoCodingData(HttpResponse<String> geoCodingRequest) {
        List<Location> geoCodingData = new ArrayList<>();
        String responseBody = geoCodingRequest.body();

        JsonArray json = JsonParser.parseString(responseBody).getAsJsonArray();

        // Based on the comment above, extract cityName, country, latitude, longitude
        for (int i = 0; i < json.size(); i++) {
            JsonObject dataToJson = json.get(i).getAsJsonObject();
            String cityName = dataToJson.get("name").getAsString();
            String countryCode = dataToJson.get("country").getAsString();
            double latitude = dataToJson.get("lat").getAsDouble();
            double longitude = dataToJson.get("lon").getAsDouble();

            Location model = new Location(cityName, countryCode, latitude, longitude);
            geoCodingData.add(model);
        }
        return geoCodingData;
    }
}
