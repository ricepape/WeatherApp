package fi.tuni.prog3.weatherapp;

import java.io.*;

public class LocationService {
    //private static final String LAST_LOCATION_FILE = "last_location.txt";

    public static Location getLastLocation() {
        return new Location("Tampere","Finland",612956.80,234713.63);
    }

    /*
    public static Location getLastLocation() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LAST_LOCATION_FILE))) {
            String line = reader.readLine();
            if (line != null && !line.isEmpty()) {
                // Assuming the format is "City,Country"
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    return new Location(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        // Return a default location if the file is not found or cannot be parsed
        return new Location("Default","Default");
    }

    public void saveLastLocation(Location location) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LAST_LOCATION_FILE))) {
            // Save location in the format "City,Country"
            writer.write(location.getName() + "," + location.getCountry());
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
     */
}
