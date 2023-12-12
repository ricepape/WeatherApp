package fi.tuni.prog3.weatherapp;

import javafx.scene.control.TextField;

public class SearchView {
    private TextField locationInput;
    private TextField latitudeInput;
    private TextField longitudeInput;

    public SearchView(TextField locationInput, TextField latitudeInput, TextField longitudeInput) {
        this.locationInput = locationInput;
        this.latitudeInput = latitudeInput;
        this.longitudeInput = longitudeInput;
    }

    public String getLocationInput() {
        return locationInput.getText();
    }
    public String getLatitudeInput() {
        return latitudeInput.getText();
    }
    public String getLongitudeInput() {
        return longitudeInput.getText();
    }
}
