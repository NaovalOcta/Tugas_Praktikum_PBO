package org.example.tugas_modul6;

import com.main.LibrarySystem;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class loginStudent_GUI extends Application {
    public static Main_GUI objMain = new Main_GUI();
    public static LibrarySystem objLibrarySystem = new LibrarySystem();
    public static StudentMenu_GUI objGUIMenuStudent = new StudentMenu_GUI();

    public static void loginResponse(int isNIMTrue) throws Exception {
        if (isNIMTrue == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText("NIM anda belum terdaftar");
            alert.setContentText("Silahkan coba lakukan pendaftaran NIM terlebih dahulu.");
            alert.showAndWait();
        } else if (isNIMTrue == 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informasi");
            alert.setHeaderText("NIM sudah benar");
            alert.setContentText("NIM Anda sudah benar, Anda telah login ke menu student.");
            alert.showAndWait();

            objGUIMenuStudent.start(new Stage());
        } else if (isNIMTrue == 2) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText("NIM Anda tidak valid");
            alert.setContentText("Silahkan coba kembali, NIM harus 15 karakter!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText("Ini adalah judul peringatan");
            alert.setContentText("Ini adalah konten peringatan.");
            alert.showAndWait();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        // VBox Layout
        VBox inputButtonVBox = new VBox(30);
        inputButtonVBox.setAlignment(Pos.CENTER);

        //HBox layout
        HBox inputNIMHBox = new HBox(10);
        inputNIMHBox.setAlignment(Pos.CENTER);
        inputButtonVBox.getChildren().add(inputNIMHBox);

        HBox buttonHBox = new HBox(10);
        buttonHBox.setAlignment(Pos.CENTER);
        inputButtonVBox.getChildren().add(buttonHBox);

        Text titleScreenTxt = new Text();
        titleScreenTxt.setText("=== Login as Student ===");
        titleScreenTxt.setTextAlignment(TextAlignment.CENTER);
        titleScreenTxt.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

        Label nimLabel = new Label();
        nimLabel.setText("Masukkan NIM Anda:");
        nimLabel.setAlignment(Pos.BASELINE_LEFT);
        nimLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        inputNIMHBox.getChildren().add(nimLabel);

        TextField nimTxtfield = new TextField();
        nimTxtfield.setAlignment(Pos.BASELINE_LEFT);
        nimTxtfield.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        inputNIMHBox.getChildren().add(nimTxtfield);

        Button signInButton = new Button();
        signInButton.setText("Sign In");
        // set width button
        signInButton.setMaxWidth(100.0);
        signInButton.setMinWidth(100.0);
        signInButton.setPrefWidth(100.0);
        // set height button
        signInButton.setMaxHeight(40.0);
        signInButton.setMinHeight(40.0);
        signInButton.setPrefHeight(40.0);
        // set font size
        signInButton.setStyle("-fx-font-size: 14px;");
        buttonHBox.getChildren().add(signInButton);

        Button backButton = new Button();
        backButton.setText("Back");
        // set width button
        backButton.setMaxWidth(100.0);
        backButton.setMinWidth(100.0);
        backButton.setPrefWidth(100.0);
        // set height button
        backButton.setMaxHeight(40.0);
        backButton.setMinHeight(40.0);
        backButton.setPrefHeight(40.0);
        // set font size
        backButton.setStyle("-fx-font-size: 14px;");
        buttonHBox.getChildren().add(backButton);

        // BUTTON 1 ACTION
        signInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    stage.close();
                    LibrarySystem.inputNim(nimTxtfield.getText());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // BUTTON 2 ACTION
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    stage.close();
                    objMain.start(new Stage());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        //VBox root layout
        VBox root = new VBox(60);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(titleScreenTxt, inputButtonVBox);

        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Login as Student");
        stage.setScene(scene);
        stage.show();
    }
}
