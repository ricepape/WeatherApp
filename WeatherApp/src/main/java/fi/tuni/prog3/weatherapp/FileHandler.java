package fi.tuni.prog3.weatherapp;

public class FileHandler implements iReadAndWriteToFile {
    @Override
    public String readFromFile(String fileName) {
        // Implement logic to read JSON from the given file
        // For simplicity, returning a placeholder response
        return "Read JSON data from file: " + fileName;
    }

    @Override
    public boolean writeToFile(String fileName) {
        // Implement logic to write student progress as JSON into the given file
        // For simplicity, returning a placeholder response
        System.out.println("Write JSON data to file: " + fileName);
        return true;
    }
}
