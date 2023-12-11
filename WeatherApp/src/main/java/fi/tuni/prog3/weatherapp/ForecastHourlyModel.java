package fi.tuni.prog3.weatherapp;

public class ForecastHourlyModel {
    private int cityId;
    private String cityName;
    private double longitude;
    private double latitude;
    private String country;
    private double temperature;
    private int timezone;
    private double pressure;
    private double humidity;
    private String weatherIcon;
    private String weatherMain;
    private double windSpeed;
    private double visibility;

    public ForecastHourlyModel(int cityId, String cityName, double longitude, double latitude,
                               String country, double temperature, int timezone, double pressure, double humidity,
                               String weatherIcon, String weatherMain, double windSpeed, double visibility) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.country = country;
        this.temperature = temperature;
        this.timezone = timezone;
        this.pressure = pressure;
        this.humidity = humidity;
        this.weatherIcon = weatherIcon;
        this.weatherMain = weatherMain;
        this.windSpeed = windSpeed;
        this.visibility = visibility;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getPressure() {
        return pressure;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherMain(String weatherMain) {
        this.weatherMain = weatherMain;
    }

    public String getWeatherMain() {
        return weatherMain;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public double getVisibility() {
        return visibility;
    }

}
