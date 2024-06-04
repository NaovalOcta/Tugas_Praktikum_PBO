package org.example.tugas_modul6;

import data.Student;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class StudentMenu_GUI extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // GridPane Layout
        GridPane gridMenu = new GridPane();
        gridMenu.setVgap(10);
        gridMenu.setAlignment(Pos.BASELINE_CENTER);

        // VBox menu button layout
        VBox menuButtonVbox = new VBox(10);
        menuButtonVbox.setAlignment(Pos.TOP_CENTER);

        Text welcomeText = new Text("=== Student Menu ===");
        welcomeText.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        welcomeText.setTextAlignment(TextAlignment.CENTER);
        gridMenu.add(welcomeText, 0,0);

        // BUTTON 1
        Button showBorrowBookStudentButton = new Button("Buku Terpinjam");
        // set width button
        showBorrowBookStudentButton.setMaxWidth(300.0);
        showBorrowBookStudentButton.setMinWidth(300.0);
        showBorrowBookStudentButton.setPrefWidth(300.0);
        // set height button
        showBorrowBookStudentButton.setMaxHeight(40.0);
        showBorrowBookStudentButton.setMinHeight(40.0);
        showBorrowBookStudentButton.setPrefHeight(40.0);
        // set font size
        showBorrowBookStudentButton.setStyle("-fx-font-size: 16px;");
        menuButtonVbox.getChildren().add(showBorrowBookStudentButton);

        // BUTTON 2
        Button borrowBookStudentButton = new Button("Pinjam Buku");
        // set width button
        borrowBookStudentButton.setMaxWidth(300.0);
        borrowBookStudentButton.setMinWidth(300.0);
        borrowBookStudentButton.setPrefWidth(300.0);
        // set height button
        borrowBookStudentButton.setMaxHeight(40.0);
        borrowBookStudentButton.setMinHeight(40.0);
        borrowBookStudentButton.setPrefHeight(40.0);
        // set font size
        borrowBookStudentButton.setStyle("-fx-font-size: 16px;");
        menuButtonVbox.getChildren().add(borrowBookStudentButton);

        // BUTTON 3
        Button returnBookButton = new Button("Kembalikan Buku");
        // set width button
        returnBookButton.setMaxWidth(300.0);
        returnBookButton.setMinWidth(300.0);
        returnBookButton.setPrefWidth(300.0);
        // set height button
        returnBookButton.setMaxHeight(40.0);
        returnBookButton.setMinHeight(40.0);
        returnBookButton.setPrefHeight(40.0);
        // set font size
        returnBookButton.setStyle("-fx-font-size: 16px;");
        menuButtonVbox.getChildren().add(returnBookButton);

        // BUTTON 4
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

        // button action
        // button display buku terpinjam
        showBorrowBookStudentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                displayBorrowedBook_GUI objGUIDisplayBorrowedBook = new displayBorrowedBook_GUI();
                try {
                    stage.close();
                    objGUIDisplayBorrowedBook.start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // button pinjam buku
        borrowBookStudentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                choiceBook_GUI objGUIChoiceBook = new choiceBook_GUI();
                try {
                    stage.close();
                    objGUIChoiceBook.start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // button kembalikan buku
        returnBookButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                returnBook_GUI objGUIReturnBook = new returnBook_GUI();
                try {
                    stage.close();
                    objGUIReturnBook.start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // button logout atau pinjam buku
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Konfirmasi");
                alert.setHeaderText("Apakah Anda ingin (langsung logout) atau (logout dan pinjam buku)?");
                alert.setContentText("Pilih OK untuk Logout dan Pinjam Buku atau Cancel untuk Langsung Logout.");
                Optional<ButtonType> result = alert.showAndWait();

                Main_GUI objGUIMain = new Main_GUI();
                Student objStudent = new Student("", "", "", "");
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    objStudent.logout(2);
                    try {
                        stage.close();
                        objGUIMain.start(new Stage());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    objStudent.logout(1);
                    try {
                        stage.close();
                        objGUIMain.start(new Stage());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        });

        //VBox root layout
        VBox root = new VBox(40);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(gridMenu, menuButtonVbox);

        FXMLLoader fxmlLoader = new FXMLLoader(Main_GUI.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Student Menu");
        stage.setScene(scene);
        stage.show();
    }
}
