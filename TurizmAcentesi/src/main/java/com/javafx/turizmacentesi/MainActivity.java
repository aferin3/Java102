package com.javafx.turizmacentesi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainActivity extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainActivity.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Patika Turizm Acentesi");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Patika Turizm Acentesi");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}