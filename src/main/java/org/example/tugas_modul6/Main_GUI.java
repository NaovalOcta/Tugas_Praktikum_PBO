package org.example.tugas_modul6;

import com.main.LibrarySystem;
import data.Admin;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class Main_GUI extends Application {
    private static loginStudent_GUI objLoginStudentGUI = new loginStudent_GUI();
    private static loginAdmin_GUI objLoginAdminGUI = new loginAdmin_GUI();
    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        showMainMenu();
    }

    public void  showMainMenu() throws IOException {
        // GridPane Layout
        GridPane gridMenu = new GridPane();
        gridMenu.setVgap(10);
        gridMenu.setAlignment(Pos.BASELINE_CENTER);

        // VBox menu button layout
        VBox menuButtonVbox = new VBox(10);
        menuButtonVbox.setAlignment(Pos.TOP_CENTER);

        Text welcomeText = new Text("=== Library System ===");
        welcomeText.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        welcomeText.setTextAlignment(TextAlignment.CENTER);
        gridMenu.add(welcomeText, 0,0);

        //BUTTON 1
        Button studentLoginButton = new Button("Login as Student");
        // set width button
        studentLoginButton.setMaxWidth(300.0);
        studentLoginButton.setMinWidth(300.0);
        studentLoginButton.setPrefWidth(300.0);
        // set height button
        studentLoginButton.setMaxHeight(40.0);
        studentLoginButton.setMinHeight(40.0);
        studentLoginButton.setPrefHeight(40.0);
        // set font size
        studentLoginButton.setStyle("-fx-font-size: 16px;");
        menuButtonVbox.getChildren().add(studentLoginButton);

        // BUTTON 2
        Button adminLoginButton = new Button("Login as Admin");
        // set width button
        adminLoginButton.setMaxWidth(300.0);
        adminLoginButton.setMinWidth(300.0);
        adminLoginButton.setPrefWidth(300.0);
        // set height button
        adminLoginButton.setMaxHeight(40.0);
        adminLoginButton.setMinHeight(40.0);
        adminLoginButton.setPrefHeight(40.0);
        // set font size
        adminLoginButton.setStyle("-fx-font-size: 16px;");
        menuButtonVbox.getChildren().add(adminLoginButton);

        // BUTTON 3
        Button exitButton = new Button("Exit Program");
        // set width button
        exitButton.setMaxWidth(300.0);
        exitButton.setMinWidth(300.0);
        exitButton.setPrefWidth(300.0);
        // set height button
        exitButton.setMaxHeight(40.0);
        exitButton.setMinHeight(40.0);
        exitButton.setPrefHeight(40.0);
        // set font size
        exitButton.setStyle("-fx-font-size: 16px;");
        menuButtonVbox.getChildren().add(exitButton);

        //BUTTON 1 ACTION
        studentLoginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    stage.close();
                    objLoginStudentGUI.start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // BUTTON 2 ACTION
        adminLoginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    stage.close();
                    objLoginAdminGUI.start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // BUTTON 3 ACTION
        exitButton.setOnAction(e -> stage.close());

        //VBox root layout
        VBox root = new VBox(40);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(gridMenu, menuButtonVbox);

        FXMLLoader fxmlLoader = new FXMLLoader(Main_GUI.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Library System - Main Page");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}