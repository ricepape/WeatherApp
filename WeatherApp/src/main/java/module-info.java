module fi.tuni.prog3.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens fi.tuni.prog3.weatherapp to javafx.fxml;
    exports fi.tuni.prog3.weatherapp;
    requires javafx.base;
    requires javafx.graphics;
    requires com.google.gson;
    requires transitive java.net.http;
}
