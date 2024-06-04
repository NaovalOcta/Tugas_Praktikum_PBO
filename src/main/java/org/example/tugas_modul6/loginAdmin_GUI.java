package org.example.tugas_modul6;

import com.main.LibrarySystem;
import data.Admin;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class loginAdmin_GUI extends Application {
    public static Main_GUI objMain = new Main_GUI();
    public static Admin objAdmin = new Admin();
    public static adminMenu_GUI objGUIMenuAdmin = new adminMenu_GUI();

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

        HBox buttonHBox = new HBox(10);
        buttonHBox.setAlignment(Pos.CENTER);
        inputButtonVBox.getChildren().add(buttonHBox);

        Text titleScreenTxt = new Text();
        titleScreenTxt.setText("=== Login as Admin ===");
        titleScreenTxt.setTextAlignment(TextAlignment.CENTER);
        titleScreenTxt.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

        Label usernameLabel = new Label();
        usernameLabel.setText("Masukkan username:");
        usernameLabel.setAlignment(Pos.TOP_LEFT);
        usernameLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        usernameHBox.getChildren().add(usernameLabel);

        TextField usernameTxtfield = new TextField();
        usernameTxtfield.setAlignment(Pos.TOP_LEFT);
        usernameTxtfield.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        usernameHBox.getChildren().add(usernameTxtfield);

        Label passLabel = new Label();
        passLabel.setText("Masukkan password:");
        passLabel.setAlignment(Pos.TOP_LEFT);
        passLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        passwordHBox.getChildren().add(passLabel);

        PasswordField passPasswordField = new PasswordField();
        passPasswordField.setAlignment(Pos.TOP_LEFT);
        passPasswordField.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        passwordHBox.getChildren().add(passPasswordField);

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

        //VBox root layout
        VBox root = new VBox(60);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(titleScreenTxt, inputButtonVBox);

        // BUTTON 1 ACTION
        signInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    boolean isAdminTrue = objAdmin.isAdmin(usernameTxtfield.getText(), passPasswordField.getText());

                    if (isAdminTrue) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Informasi");
                        alert.setHeaderText("Anda berhasil login!");
                        alert.setContentText("Anda telah login ke menu admin");
                        alert.showAndWait();

                        stage.close();
                        objGUIMenuAdmin.start(new Stage());
                    } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Peringatan");
                        alert.setHeaderText("Username / Password salah");
                        alert.setContentText("Silahkan coba lagi, pastikan memasukkan username dan password dengan benar.");
                        alert.showAndWait();
                    }
                } catch (Exception e) {
//                    throw new RuntimeException(e);
                    System.err.println(e.getMessage());
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Peringatan");
                    alert.setHeaderText("Username / Password salah");
                    alert.setContentText("Silahkan coba lagi, pastikan memasukkan username dan password dengan benar.");
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
                    objMain.start(new Stage());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("System Library - Login Admin");
        stage.setScene(scene);
        stage.show();
    }
}
