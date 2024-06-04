package org.example.tugas_modul6;

import data.Admin;
import data.Student;
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

public class addStudent_GUI extends Application {
    public static adminMenu_GUI objGUIMenuAdmin = new adminMenu_GUI();
    public static Admin objAdmin = new Admin();

    @Override
    public void start(Stage stage) throws Exception {
        // VBox Layout
        VBox inputButtonVBox = new VBox(30);
        inputButtonVBox.setAlignment(Pos.CENTER);

        VBox inputLayoutVBox = new VBox(10);
        inputLayoutVBox.setAlignment(Pos.CENTER);
        inputButtonVBox.getChildren().add(inputLayoutVBox);

        //HBox layout
        HBox usernameHBox = new HBox(10);
        usernameHBox.setAlignment(Pos.CENTER);
        inputLayoutVBox.getChildren().add(usernameHBox);

        HBox passwordHBox = new HBox(10);
        passwordHBox.setAlignment(Pos.CENTER);
        inputLayoutVBox.getChildren().add(passwordHBox);

        HBox facultyHBox = new HBox(10);
        facultyHBox.setAlignment(Pos.CENTER);
        inputLayoutVBox.getChildren().add(facultyHBox);

        HBox programStudiHBox = new HBox(10);
        programStudiHBox.setAlignment(Pos.CENTER);
        inputLayoutVBox.getChildren().add(programStudiHBox);

        HBox buttonHBox = new HBox(10);
        buttonHBox.setAlignment(Pos.CENTER);
        inputButtonVBox.getChildren().add(buttonHBox);

        Text titleScreenTxt = new Text();
        titleScreenTxt.setText("=== Add Student ===");
        titleScreenTxt.setTextAlignment(TextAlignment.CENTER);
        titleScreenTxt.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

        Label nameLabel = new Label();
        nameLabel.setText("Masukkan nama:");
        nameLabel.setAlignment(Pos.TOP_LEFT);
        nameLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        usernameHBox.getChildren().add(nameLabel);

        TextField nameTxtfield = new TextField();
        nameTxtfield.setAlignment(Pos.TOP_LEFT);
        nameTxtfield.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        usernameHBox.getChildren().add(nameTxtfield);

        Label nimLabel = new Label();
        nimLabel.setText("Masukkan NIM:");
        nimLabel.setAlignment(Pos.TOP_LEFT);
        nimLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        passwordHBox.getChildren().add(nimLabel);

        TextField nimTxtfield = new TextField();
        nimTxtfield.setAlignment(Pos.TOP_LEFT);
        nimTxtfield.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        passwordHBox.getChildren().add(nimTxtfield);

        Label facultyLabel = new Label();
        facultyLabel.setText("Masukkan Fakultas:");
        facultyLabel.setAlignment(Pos.TOP_LEFT);
        facultyLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        facultyHBox.getChildren().add(facultyLabel);

        TextField facultyTxtfield = new TextField();
        facultyTxtfield.setAlignment(Pos.TOP_LEFT);
        facultyTxtfield.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        facultyHBox.getChildren().add(facultyTxtfield);

        Label programStudiLabel = new Label();
        programStudiLabel.setText("Masukkan Program Studi:");
        programStudiLabel.setAlignment(Pos.TOP_LEFT);
        programStudiLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        programStudiHBox.getChildren().add(programStudiLabel);

        TextField programStudiTxtfield = new TextField();
        programStudiTxtfield.setAlignment(Pos.TOP_LEFT);
        programStudiTxtfield.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        programStudiHBox.getChildren().add(programStudiTxtfield);

        Button addButton = new Button();
        addButton.setText("Add");
        // set width button
        addButton.setMaxWidth(100.0);
        addButton.setMinWidth(100.0);
        addButton.setPrefWidth(100.0);
        // set height button
        addButton.setMaxHeight(40.0);
        addButton.setMinHeight(40.0);
        addButton.setPrefHeight(40.0);
        // set font size
        addButton.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        buttonHBox.getChildren().add(addButton);

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
        backButton.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        buttonHBox.getChildren().add(backButton);

        //VBox root layout
        VBox root = new VBox(60);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(titleScreenTxt, inputButtonVBox);

        // BUTTON 1 ACTION
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int response = objAdmin.addStudent(nameTxtfield.getText(), nimTxtfield.getText(), facultyTxtfield.getText(), programStudiTxtfield
                        .getText());

                if (response == 0) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Peringatan");
                    alert.setHeaderText("NIM tidak valid!");
                    alert.setContentText("Silahkan coba kembali, NIM harus 15 karakter.");
                    alert.showAndWait();

                } else if (response == 1) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Informasi");
                    alert.setHeaderText("Berhasil ditambahkan");
                    alert.setContentText("Mahasiswa dengan NIM " + nimTxtfield.getText() + " berhasil ditambahkan.");
                    alert.showAndWait();

                } else if (response == 2) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Peringatan");
                    alert.setHeaderText("NIM sudah terdaftar!");
                    alert.setContentText("NIM yang anda masukkan sudah terdaftar, silahkan coba kembali.");
                    alert.showAndWait();

                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Peringatan");
                    alert.setHeaderText("Data Response Error");
                    alert.setContentText("Response dari kode Anda tidak jelas, silahkan cek kembali.");
                    alert.showAndWait();

                }
            }
        });

        // BUTTON 2 ACTION
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    stage.close();
                    objGUIMenuAdmin.start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Add Student Page");
        stage.setScene(scene);
        stage.show();
    }
}
