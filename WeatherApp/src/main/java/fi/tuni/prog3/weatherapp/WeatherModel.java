package fi.tuni.prog3.weatherapp;

public class WeatherModel {

    private double temperature;
    private double maxTemp;
    private double minTemp;
    private String iconCode;

    public WeatherModel() {

    }

    public WeatherModel(double temperature, double maxTemp, double minTemp, String iconCode) {
        this.temperature = temperature;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.iconCode = iconCode;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public String getIconCode() {
        return iconCode;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public void setIconCode(String iconCode) {
        this.iconCode = iconCode;
    }
}
