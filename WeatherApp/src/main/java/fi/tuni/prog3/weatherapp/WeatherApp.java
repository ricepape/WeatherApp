package fi.tuni.prog3.weatherapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Parent;

import javafx.fxml.FXMLLoader;

import java.io.IOException;


/**
 * JavaFX Sisu
 */
public class WeatherApp extends Application {
    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws IOException{

        System.out.println("FXML URL: " + WeatherApp.class.getResource("Main.fxml"));

        // Load main FXML and set up scene
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        //Parent root = loader.load();

        // Set the controller
        //MainWindowController controller = loader.getController();

        scene = new Scene(loadFXML("Main"));
        //AnchorPane anchorPane = new AnchorPane();

        primaryStage.setTitle("Weather App");

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WeatherApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    /*
    private VBox getCenterVBox() {
        //Creating an HBox.
        VBox centerHBox = new VBox(10);
        
        //Adding two VBox to the HBox.
        centerHBox.getChildren().addAll(getTopHBox(), getBottomHBox());
        
        return centerHBox;
    }
    
    private HBox getTopHBox() {
        //Creating a VBox for the left side.
        HBox leftHBox = new HBox();
        leftHBox.setPrefHeight(330);
        leftHBox.setStyle("-fx-background-color: #8fc6fd;");
        
        leftHBox.getChildren().add(new Label("Top Panel"));
        
        return leftHBox;
    }
    
    private HBox getBottomHBox() {
        //Creating a VBox for the right side.
        HBox rightHBox = new HBox();
        rightHBox.setPrefHeight(330);
        rightHBox.setStyle("-fx-background-color: #b1c2d4;");
        
        rightHBox.getChildren().add(new Label("Bottom Panel"));
        
        return rightHBox;
    }
    
    private Button getQuitButton() {
        //Creating a button.
        Button button = new Button("Quit");
        
        //Adding an event to the button to terminate the application.
        button.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
        
        return button;
    }*/
}