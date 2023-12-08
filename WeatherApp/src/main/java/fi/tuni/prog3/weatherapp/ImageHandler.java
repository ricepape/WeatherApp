package fi.tuni.prog3.weatherappui;

public class ImageHandler {
    public static String getImage(String icon) {
        switch (icon) {
            case "01":
                return "partlysunny.png";
            case "02":
                return "severesnow.png";
            case "03":
                return "snow.png";
        }
        return "snow.png";
    }
}
