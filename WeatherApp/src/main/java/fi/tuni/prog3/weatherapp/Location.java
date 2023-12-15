package fi.tuni.prog3.weatherapp;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * author: Anh Tran, Thi Vu
 */
public class Location {
    public static List<LocationModel> fetchLocationData(HttpResponse<String> response) {
       
        String responseBody = response.body();
        List<LocationModel> locationList = new ArrayList<>();

        // Parse the JSON response
        // JsonObject json = JsonParser.parseString(responseBody).getAsJsonObject();

            JsonArray listLocationDataReturn = JsonParser.parseString(responseBody).getAsJsonArray();
            for (int i = 0; i < listLocationDataReturn.size(); i++) {
                LocationModel locationModel = new LocationModel();
                JsonObject dataToJson = listLocationDataReturn.get(i).getAsJsonObject();
                String name = dataToJson.get("name").getAsString();
                double lat = dataToJson.get("lat").getAsDouble();
                double lon = dataToJson.get("lon").getAsDouble();
                String country = dataToJson.get("country").getAsString();
                locationModel = new LocationModel(name, lat, lon, country); 
                locationList.add(locationModel);
        }
        return locationList;
    }
    
    
}