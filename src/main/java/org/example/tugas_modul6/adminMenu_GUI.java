package org.example.tugas_modul6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class adminMenu_GUI extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // GridPane Layout
        GridPane gridMenu = new GridPane();
        gridMenu.setVgap(10);
        gridMenu.setAlignment(Pos.BASELINE_CENTER);

        // VBox menu button layout
        VBox menuButtonVbox = new VBox(10);
        menuButtonVbox.setAlignment(Pos.TOP_CENTER);

        Text welcomeText = new Text("=== Admin Menu ===");
        welcomeText.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        welcomeText.setTextAlignment(TextAlignment.CENTER);
        gridMenu.add(welcomeText, 0,0);

        // BUTTON 1
        Button addStudentButton = new Button("Add Student");
        // set width button
        addStudentButton.setMaxWidth(300.0);
        addStudentButton.setMinWidth(300.0);
        addStudentButton.setPrefWidth(300.0);
        // set height button
        addStudentButton.setMaxHeight(40.0);
        addStudentButton.setMinHeight(40.0);
        addStudentButton.setPrefHeight(40.0);
        // set font size
        addStudentButton.setStyle("-fx-font-size: 16px;");
        menuButtonVbox.getChildren().add(addStudentButton);

        // BUTTON 2
        Button addBookButton = new Button("Add Book");
        // set width button
        addBookButton.setMaxWidth(300.0);
        addBookButton.setMinWidth(300.0);
        addBookButton.setPrefWidth(300.0);
        // set height button
        addBookButton.setMaxHeight(40.0);
        addBookButton.setMinHeight(40.0);
        addBookButton.setPrefHeight(40.0);
        // set font size
        addBookButton.setStyle("-fx-font-size: 16px;");
        menuButtonVbox.getChildren().add(addBookButton);

        // BUTTON 3
        Button displayRegisteredStudentButton = new Button("Display Registered Student");
        // set width button
        displayRegisteredStudentButton.setMaxWidth(300.0);
        displayRegisteredStudentButton.setMinWidth(300.0);
        displayRegisteredStudentButton.setPrefWidth(300.0);
        // set height button
        displayRegisteredStudentButton.setMaxHeight(40.0);
        displayRegisteredStudentButton.setMinHeight(40.0);
        displayRegisteredStudentButton.setPrefHeight(40.0);
        // set font size
        displayRegisteredStudentButton.setStyle("-fx-font-size: 16px;");
        menuButtonVbox.getChildren().add(displayRegisteredStudentButton);

        // BUTTON 4
        Button displayAvailableBook = new Button("Display Available Books");
        // set width button
        displayAvailableBook.setMaxWidth(300.0);
        displayAvailableBook.setMinWidth(300.0);
        displayAvailableBook.setPrefWidth(300.0);
        // set height button
        displayAvailableBook.setMaxHeight(40.0);
        displayAvailableBook.setMinHeight(40.0);
        displayAvailableBook.setPrefHeight(40.0);
        // set font size
        displayAvailableBook.setStyle("-fx-font-size: 16px;");
        menuButtonVbox.getChildren().add(displayAvailableBook);

        // BUTTON 5
        Button exitButton = new Button("Logout");
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

        // BUTTON ACTION
        // BUTTON 1
        addStudentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
                try {
                    addStudent_GUI objGUIAddStudent = new addStudent_GUI();
                    objGUIAddStudent.start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // BUTTON 2
        addBookButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
                try {
                    addBook_GUI objGUITambahBuku = new addBook_GUI();
                    objGUITambahBuku.start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // BUTTON 3
        displayRegisteredStudentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
                try {
                    displayRegisteredStudent_GUI objGUIDisplayStudent = new displayRegisteredStudent_GUI();
                    objGUIDisplayStudent.start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // BUTTON 4
        displayAvailableBook.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
                displayAvailableBook_GUI objGUIDisplayBook = new displayAvailableBook_GUI();
                try {
                    objGUIDisplayBook.start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // BUTTON 5
        exitButton.setOnAction(e -> {
            Main_GUI objMain = new Main_GUI();
            try {
                stage.close();
                objMain.start(new Stage());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        //VBox root layout
        VBox root = new VBox(40);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(gridMenu, menuButtonVbox);

        FXMLLoader fxmlLoader = new FXMLLoader(Main_GUI.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("System Library - Admin Menu");
        stage.setScene(scene);
        stage.show();
    }
}
