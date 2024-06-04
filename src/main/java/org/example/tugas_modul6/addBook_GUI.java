package org.example.tugas_modul6;

import data.Admin;
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

public class addBook_GUI extends Application {
    public inputBook objInputBook = new inputBook();

    private int choiceCategory;

    @Override
    public void start(Stage stage) throws Exception {
        // VBox Layout
        VBox buttonLayout = new VBox();
        buttonLayout.setAlignment(Pos.TOP_CENTER);
        buttonLayout.setSpacing(10);

        // TITLE
        Text titleTxt = new Text();
        titleTxt.setText("Pilih Jenis Buku");
        titleTxt.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        titleTxt.setTextAlignment(TextAlignment.CENTER);

        // BUTTON 1
        Button historyButton = new Button();
        historyButton.setText("History Book");
        // set width button
        historyButton.setPrefWidth(300.0);
        // set height button
        historyButton.setPrefHeight(40.0);
        // set font size
        historyButton.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // BUTTON 2
        Button storyButton = new Button();
        storyButton.setText("Story Book");
        // set width button
        storyButton.setPrefWidth(300.0);
        // set height button
        storyButton.setPrefHeight(40.0);
        // set font size
        storyButton.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // BUTTON 3
        Button textButton = new Button();
        textButton.setText("Text Book");
        // set width button
        textButton.setPrefWidth(300.0);
        // set height button
        textButton.setPrefHeight(40.0);
        // set font size
        textButton.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // BUTTON 4
        Button backButton = new Button();
        backButton.setText("Back");
        // set width button
        backButton.setPrefWidth(300.0);
        // set height button
        backButton.setPrefHeight(40.0);
        // set font size
        backButton.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        buttonLayout.getChildren().addAll(historyButton, storyButton, textButton);

        // BUTTON ACTION
        // BUTTON 1
        historyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    choiceCategory = 1;
                    stage.close();
                    objInputBook.start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // BUTTON 2
        storyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    choiceCategory = 2;
                    stage.close();
                    objInputBook.start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // BUTTON 3
        textButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    choiceCategory = 3;
                    stage.close();
                    objInputBook.start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // BUTTON 4
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                adminMenu_GUI objGUIAdminMenu = new adminMenu_GUI();
                try {
                    stage.close();
                    objGUIAdminMenu.start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Root VBox Layout
        VBox root = new VBox();
        root.setSpacing(30);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(titleTxt, buttonLayout, backButton);

        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Library System - Choice Book Category");
        stage.setScene(scene);
        stage.show();
    }

    class inputBook extends Application{

        @Override
        public void start(Stage stage) throws Exception {
            // VBox Layout
            VBox inputButtonVBox = new VBox(30);
            inputButtonVBox.setAlignment(Pos.CENTER);

            VBox inputLayoutVBox = new VBox(10);
            inputLayoutVBox.setAlignment(Pos.CENTER);
            inputButtonVBox.getChildren().add(inputLayoutVBox);

            //HBox layout
            HBox judulBukuHBox = new HBox(10);
            judulBukuHBox.setAlignment(Pos.CENTER);
            inputLayoutVBox.getChildren().add(judulBukuHBox);

            HBox authorHBox = new HBox(10);
            authorHBox.setAlignment(Pos.CENTER);
            inputLayoutVBox.getChildren().add(authorHBox);

            HBox stockHBox = new HBox(10);
            stockHBox.setAlignment(Pos.CENTER);
            inputLayoutVBox.getChildren().add(stockHBox);

            HBox buttonHBox = new HBox(10);
            buttonHBox.setAlignment(Pos.CENTER);
            inputButtonVBox.getChildren().add(buttonHBox);

            Text titleScreenTxt = new Text();
            titleScreenTxt.setText("=== Add Book ===");
            titleScreenTxt.setTextAlignment(TextAlignment.CENTER);
            titleScreenTxt.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

            Label judulBukuLabel = new Label();
            judulBukuLabel.setText("Masukkan judul buku:");
            judulBukuLabel.setAlignment(Pos.TOP_LEFT);
            judulBukuLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
            judulBukuHBox.getChildren().add(judulBukuLabel);

            TextField judulBukuTxtfield = new TextField();
            judulBukuTxtfield.setAlignment(Pos.TOP_LEFT);
            judulBukuTxtfield.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
            judulBukuHBox.getChildren().add(judulBukuTxtfield);

            Label authorBukuLabel = new Label();
            authorBukuLabel.setText("Masukkan author buku:");
            authorBukuLabel.setAlignment(Pos.TOP_LEFT);
            authorBukuLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
            authorHBox.getChildren().add(authorBukuLabel);

            TextField authorBukuTxtfield = new TextField();
            authorBukuTxtfield.setAlignment(Pos.TOP_LEFT);
            authorBukuTxtfield.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
            authorHBox.getChildren().add(authorBukuTxtfield);

            Label stockBukuLabel = new Label();
            stockBukuLabel.setText("Masukkan jumlah stock buku:");
            stockBukuLabel.setAlignment(Pos.TOP_LEFT);
            stockBukuLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
            stockHBox.getChildren().add(stockBukuLabel);

            TextField stockBukuTxtfield = new TextField();
            stockBukuTxtfield.setAlignment(Pos.TOP_LEFT);
            stockBukuTxtfield.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
            stockHBox.getChildren().add(stockBukuTxtfield);

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
                    Admin objAdmin = new Admin();
                    int response = objAdmin.inputBook(choiceCategory, judulBukuTxtfield.getText(), authorBukuTxtfield.getText(), Integer.parseInt(stockBukuTxtfield.getText()));

                    if (response == 0) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Peringatan");
                        alert.setHeaderText("Pilihan tidak valid!");
                        alert.setContentText("Silahkan coba kembali.");
                        alert.showAndWait();

                    } else if (response == 1) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Informasi");
                        alert.setHeaderText("Berhasil ditambahkan");
                        alert.setContentText("Buku telah berhasil ditambahkan.");
                        alert.showAndWait();
                        System.out.println();

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
                        adminMenu_GUI objGUIAdminMenu = new adminMenu_GUI();
                        objGUIAdminMenu.start(new Stage());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            Scene scene = new Scene(root, 600, 600);
            stage.setTitle("Library System - Add Book");
            stage.setScene(scene);
            stage.show();
        }
    }
}
