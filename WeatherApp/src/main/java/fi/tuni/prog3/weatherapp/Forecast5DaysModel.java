package fi.tuni.prog3.weatherapp;

public class Forecast5DaysModel {
    private String cityName;
    private String countryCode;
    private double longitude;
    private double latitude;
    private int timezone;
    private int timestamp;
    private String weatherImage;
    private double maxTemp;
    private double minTemp;

    public Forecast5DaysModel(String cityName, String countryCode, double longitude, double latitude, int timezone,
                              int timestamp, String weatherImage, double maxTemp, double minTemp) {
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.longitude = longitude;
        this.latitude = latitude;
        this.timestamp = timestamp;
        this.timezone = timezone;
        this.weatherImage = weatherImage;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

}
