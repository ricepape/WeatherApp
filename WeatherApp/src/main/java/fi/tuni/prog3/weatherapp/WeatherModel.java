/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

/**
 *
 * @author vudinhthi2304
 */
public class WeatherModel {

    private double temp_max;
    private double temp;
    private double temp_min;
    private double feels_like;
    private double pressure;
    private double humidity;
    private double wind_speed;
    private double rain_intensity;
    private String weather_description;
    private String iconCode;
    
    
    public WeatherModel() {

    }
    
    public WeatherModel(double temp, double temp_max, double temp_min,
            double feels_like, double humidity, double pressure, 
            double wind_speed, double rain_intensity, String weather_description, String iconCode) {
        this.temp = temp;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
        this.feels_like = feels_like;
        this.humidity = humidity;
        this.pressure = pressure;
        this.wind_speed = wind_speed;
        this.rain_intensity = rain_intensity;
        this.weather_description = weather_description;
        this.iconCode = iconCode;
    }
    
    
    /**
     * Get Temperature in Celsius
     *
     * @return temperature in Celsius
     */
    public double getTemperature() {
        return temp;
    }

    /**
     * Get max temperature in Celsius
     *
     * @return max temperature in Celsius
     */
    public double getMaxTemperature() {
        return temp_max;
    }

    /**
     * Get min temperature in Celsius
     *
     * @return min temperature in Celsius
     */
    public double getMinTemperature() {
        return temp_min;
    }

    /**
     * Get feels like temperature in Celsius
     *
     * @return feels like temperature in Celsius
     */
    public double getFeelsLike() {
        return feels_like;
    }

    /**
     * Get humidity in Celsius
     *
     * @return humidity in Celsius
     */
    public double getHumidity() {
        return humidity;
    }

    /**
     * Get pressure in Celsius
     *
     * @return pressure in Celsius
     */
    public double getPressure() {
        return pressure;
    }

    /**
     * Get weather description
     *
     * @return weather description
     */
    public String getWeatherDescription() {
        return weather_description;
    }

    /**
     * Get weather description
     *
     * @return weather description
     */
    public double getRainIntensity() {
        return rain_intensity;
    }

    /**
     * Get weather description
     *
     * @return weather description
     */
    public double getWindSpeed() {
        return wind_speed;
    }

    /**
     * Set temperature in Celsius
     *
     * @param temperature
     */
    public void setTemperature(double temperature) {
        this.temp = temperature;
    }

    /**
     * Set max temperature in Celsius
     *
     * @param maxTemperature
     */
    public void setMaxTemperature(double maxTemperature) {
        this.temp_max = maxTemperature;
    }

    /**
     * Set min temperature in Celsius
     *
     * @param minTemperature
     */
    public void setMinTemperature(double minTemperature) {
        this.temp_min = minTemperature;
    }

    /**
     * Set feels like temperature in Celsius
     *
     * @param feelsLike
     */
    public void setFeelsLike(double feelsLike) {
        this.feels_like = feelsLike;
    }

    /**
     * Set humidity in Celsius
     *
     * @param humidity
     */
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    /**
     * Set pressure in Celsius
     *
     * @param pressure
     */
    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    /**
     * Set weather description
     *
     * @param weatherDescription
     */
    public void setWeatherDescription(String weatherDescription) {
        this.weather_description = weatherDescription;
    }

    /**
     * Get icon code
     *
     * @return icon code
     */
    public String getIconCode() {
        return iconCode;
    }

    /**
     * Set icon code
     * 
     * @param iconCode
     */
    public void setIconCode(String iconCode) {
        this.iconCode = iconCode;
    }

    /**
     * Set icon code
     * 
     * @param wind_speed
     */
    public void setWindSpeed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    /**
     * Set icon code
     * 
     * @param rain_intensity
     */
    public void setRainIntensity(double rain_intensity) {
        this.rain_intensity = rain_intensity;
    }

}
