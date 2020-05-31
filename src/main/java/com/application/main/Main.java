package com.application.main;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
        primaryStage.setTitle("Классный руководитель 2000");
        primaryStage.setScene(new Scene(root, 1500, 800));
        primaryStage.getIcons().add(new Image("/images/main_icon.png"));
        primaryStage.show();
    }

}
