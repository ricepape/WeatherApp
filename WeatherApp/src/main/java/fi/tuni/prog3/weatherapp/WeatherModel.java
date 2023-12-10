package fi.tuni.prog3.weatherapp;

public class WeatherModel {

    private double temperature;
    private double maxTemp;
    private double minTemp;
    private String iconCode;
    private double feelsLike;
    private double rainIntensity;
    private double windSpeed;
    private String airQuality;

    public WeatherModel() {

    }

    public WeatherModel(double temperature, double maxTemp, double minTemp, String iconCode,
                        double feelsLike, double rainIntensity, double windSpeed, String airQuality) {
        this.temperature = temperature;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.iconCode = iconCode;
        this.feelsLike = feelsLike;
        this.rainIntensity = rainIntensity;
        this.windSpeed = windSpeed;
        this.airQuality = airQuality;
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

    public double getFeelsLike() { return feelsLike; }

    public double getRainIntensity() { return rainIntensity; }

    public double getWindSpeed() { return windSpeed; }

    public String getAirQuality() { return airQuality; }

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
