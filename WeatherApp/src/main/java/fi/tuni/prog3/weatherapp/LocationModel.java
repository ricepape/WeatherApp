/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.weatherapp;

/**
 *
 * author: Anh Tran, Thi Vu
 */
public class LocationModel {
    
    private String name;
    private double lat;
    private double lon;
    private String country;

    public LocationModel() {
    }
    
    public LocationModel(String name, double lat, double lon, String country) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.country = country;
    }

    /**
     * Get Temperature in Celsius
     *
     * @return temperature in Celsius
     */
    public String getName() {
        return name;
    }

    /**
     * Get Latitude
     *
     * @return Latitude 
     */
    public double getLatitude() {
        return lat;
    }

    /**
     * Get longitude
     *
     * @return longitude
     */
    public double getLongitude() {
        return lon;
    }

    /**
     * Get Country
     *
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Set name of location
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set latitude of location
     *
     * @param lat
     */
    public void setLatitude(double lat) {
        this.lat = lat;
    }

    /**
     * Set latitude of location
     *
     * @param lon
     */
    public void setLongtitude(double lon) {
        this.lon = lon;
    }

    /**
     * Set country of location
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }
 

}
