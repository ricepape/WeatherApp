/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author vudinhthi2304
 */
public class Forecast {
    public static List<ForecastModel> fetchForecastData(HttpResponse<String> response) {
       String responseBody = response.body();
       List<ForecastModel> ForecastList = new ArrayList<>();
       JsonObject json = JsonParser.parseString(responseBody).getAsJsonObject();

       JsonArray listForecastDataReturn = json.getAsJsonArray("list");
            for (int i = 0; i < listForecastDataReturn.size(); i++) {
                ForecastModel model = new ForecastModel();
                JsonObject dataToJson = listForecastDataReturn.get(i).getAsJsonObject();
                int dt = dataToJson.get("dt").getAsInt();
                JsonObject main = dataToJson.getAsJsonObject("main");
                double temp = main.get("temp").getAsDouble();
                double feels_like = main.get("feels_like").getAsDouble();
                double temp_min = main.get("temp_min").getAsDouble();
                double temp_max = main.get("temp_max").getAsDouble();
                double pressure = main.get("pressure").getAsDouble();
                double humidity = main.get("humidity").getAsDouble();
                JsonArray weatherArray = dataToJson.getAsJsonArray("weather");
                JsonObject weatherObject = weatherArray.get(0).getAsJsonObject();
                int weatherId = weatherObject.get("id").getAsInt();
                String weatherMain = weatherObject.get("main").getAsString();
                String weatherDescription = weatherObject.get("description").getAsString();
                String weatherIcon = weatherObject.get("icon").getAsString();
                double cloudsAll = dataToJson.getAsJsonObject("clouds").get("all").getAsDouble();
                double windSpeed = dataToJson.getAsJsonObject("wind").get("speed").getAsDouble();
                String sysPod = dataToJson.getAsJsonObject("sys").get("pod").getAsString();
                String dtTxt = dataToJson.get("dt_txt").getAsString();
                model = new ForecastModel(dt, temp, feels_like, temp_min, temp_max, pressure, humidity, weatherId, weatherMain, weatherDescription, weatherIcon, cloudsAll, windSpeed, sysPod, dtTxt);
                ForecastList.add(model);
        }
        return ForecastList;

      }

    }

