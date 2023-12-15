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
import javafx.scene.image.ImageView;

/**
 *
 * author: Thi Vu, Anh Tran
 */
public class Forecast {
    public static List<ForecastModel> fetchForecastData(HttpResponse<String> response) {
        List<ForecastModel> ForecastList = new ArrayList<>();
        String responseBody = response.body();
        JsonObject json = JsonParser.parseString(responseBody).getAsJsonObject();

        JsonArray listForecastDataReturn = json.getAsJsonArray("list");
        if (listForecastDataReturn != null) {
            for (int i = 0; i < listForecastDataReturn.size(); i++) {
                ForecastModel model;
                JsonObject dataToJson = listForecastDataReturn.get(i).getAsJsonObject();
                int dt = dataToJson.get("dt").getAsInt();
                JsonObject main = dataToJson.getAsJsonObject("main");
                double temp = convertTemp(main.get("temp").getAsDouble());
                double feels_like = convertTemp(main.get("feels_like").getAsDouble());
                double temp_min = convertTemp(main.get("temp_min").getAsDouble());
                double temp_max = convertTemp(main.get("temp_max").getAsDouble());
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
                ImageView weatherImage = weatherImage(weatherIcon);

                model = new ForecastModel(dt, temp, feels_like, temp_min, temp_max, pressure, humidity, weatherId,
                        weatherMain, weatherDescription, weatherIcon, cloudsAll, windSpeed, sysPod, dtTxt, weatherImage);
                ForecastList.add(model);
            }


        } else {
            // Handling error properly
        }
        return ForecastList;
    }

    /**
     * Converting temperature from kelvin to celsius
     * @param temperature in celsius
     * @return double
     */
    private static double convertTemp(double temperature) {
        return Math.floor((temperature - 273.15) * 100) / 100;
    }

    /**
     * Fetching weather icon from code input
     * @param iconCode in String
     * @return ImageView
     */
    private static ImageView weatherImage(String iconCode) {
        return new ImageView("https://openweathermap.org/img/wn/" + iconCode + "@2x.png");
    }

}
