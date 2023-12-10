package fi.tuni.prog3.weatherapp;

public class Location {
    private String cityName;
    private String country;
    private double lat;
    private double lon;

    public Location(String cityName, String country, double lat, double lon) {
        this.cityName = cityName;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
    }

    // Getter methods

    public String getCityName() {
        return cityName;
    }

    public String getCountry() {
        return country;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

}
