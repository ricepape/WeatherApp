package fi.tuni.prog3.weatherapp;

public class Forecast5DaysModel {
    private String cityName;
    private String countryCode;
    private String longitude;
    private String latitude;
    private int timezone;
    private int timestamp;
    private String weatherImage;
    private double maxTemp;
    private double minTemp;

    public Forecast5DaysModel(String cityName, String countryCode, String longitude, String latitude, int timezone,
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setWeatherImage(String weatherImage) {
        this.weatherImage = weatherImage;
    }

    public String getWeatherImage() {
        return weatherImage;
    }
}
