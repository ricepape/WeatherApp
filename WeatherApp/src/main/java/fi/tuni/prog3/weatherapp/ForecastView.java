package fi.tuni.prog3.weatherapp;

import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ForecastView {
    private TabPane forecastTabPane;
    private Label dayLabel;
    private Label maxTempLabel;
    private Label minTempLabel;
    private ImageView titleImage;
    private ImageView weatherImage;

    public ForecastView(TabPane forecastTabPane, Label dayLabel, Label maxTempLabel, Label minTempLabel,
                        ImageView titleImage, ImageView weatherImage) {
        this.forecastTabPane = forecastTabPane;
        this.dayLabel = dayLabel;
        this.maxTempLabel = maxTempLabel;
        this.minTempLabel = minTempLabel;
        this.titleImage = titleImage;
        this.weatherImage = weatherImage;
    }

    public void setMaxTempLabel(String maxTemp) {maxTempLabel.setText(maxTemp);}

    public void setMinTempLabel(String minTemp) {minTempLabel.setText(minTemp);}

    public void setWeatherImage(String imageUrl) {
        Image weatherIconImage = new Image(imageUrl);
        weatherImage.setImage(weatherIconImage);
    }

    public void setTitleImage(String imageUrl) {
        Image weatherIconImage = new Image(imageUrl);
        titleImage.setImage(weatherIconImage);
    }

    public void setDayLabel(String day) {
        dayLabel.setText(day);
    }
}
