package org.example.tugas_modul6;

import data.Student;
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

public class choiceBook_GUI extends Application {
    public static Student objStudent = new Student("", "", "", "");

    public static void dataResponse(int response) {
        if (response == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText("Durasi Buku Invalid");
            alert.setContentText("Durasi buku harus lebih dari 0!.");
            alert.showAndWait();

        } else if (response == 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informasi");
            alert.setHeaderText("Buku berhasil dipinjam");
            alert.setContentText("Anda telah berhasil meminjam buku.");
            alert.showAndWait();
            try {
                Stage currentStage = (Stage) alert.getDialogPane().getScene().getWindow();
                currentStage.close();

                StudentMenu_GUI objGUIStudentMenu = new StudentMenu_GUI();
                objGUIStudentMenu.start(new Stage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else if (response == 2) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText("Durasi Buku Invalid");
            alert.setContentText("Durasi tidak boleh dipinjam lebih dari 14 hari!.");
            alert.showAndWait();

        } else if (response == 3) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText("Id Buku Invalid");
            alert.setContentText("Buku tidak tersedia atau ID Buku tidak ditemukan, silahkan coba lagi.");
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
        // input button layout VBox
        VBox inputLayout = new VBox();
        inputLayout.setSpacing(10);
        inputLayout.setAlignment(Pos.CENTER);

        // judul halaman
        Text titleTXT = new Text();
        titleTXT.setText("Pinjam Buku");
        titleTXT.setTextAlignment(TextAlignment.CENTER);
        titleTXT.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

        // input id buku layout HBox
        HBox inputIDBukuLayout = new HBox();
        inputIDBukuLayout.setAlignment(Pos.TOP_CENTER);
        inputIDBukuLayout.setSpacing(10);

        // input durasi layout HBox
        HBox inputDurasiLayout = new HBox();
        inputDurasiLayout.setAlignment(Pos.TOP_CENTER);
        inputDurasiLayout.setSpacing(10);

        // button layout HBox
        HBox buttonLayout = new HBox();
        buttonLayout.setAlignment(Pos.TOP_CENTER);
        buttonLayout.setSpacing(10);

        Label idBukuLabel = new Label();
        idBukuLabel.setText("ID Buku");
        idBukuLabel.setAlignment(Pos.CENTER);
        idBukuLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));

        TextField idBukuTxtField = new TextField();
        idBukuTxtField.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        idBukuTxtField.setAlignment(Pos.TOP_LEFT);
        idBukuTxtField.setPromptText("Masukkan ID Buku yang ingin dipinjam");

        inputIDBukuLayout.getChildren().addAll(idBukuLabel, idBukuTxtField);

        Label durasiLabel = new Label();
        durasiLabel.setText("Durasi pinjam");
        durasiLabel.setAlignment(Pos.CENTER);
        durasiLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));

        TextField durasiTxtField = new TextField();
        durasiTxtField.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        durasiTxtField.setAlignment(Pos.TOP_LEFT);
        durasiTxtField.setPromptText("Masukkan lama peminjaman buku");

        inputDurasiLayout.getChildren().addAll(durasiLabel, durasiTxtField);

        // button display available book
        Button displayAvailableBookBTN = new Button();
        displayAvailableBookBTN.setText("Display Available Book");
        displayAvailableBookBTN.setPrefWidth(250.0);
        displayAvailableBookBTN.setPrefHeight(40.0);
        displayAvailableBookBTN.setStyle("-fx-font-size: 14px;");

        // button pinjam buku
        Button borrowBookBTN = new Button();
        borrowBookBTN.setText("Pinjam");
        borrowBookBTN.setPrefWidth(150.0);
        borrowBookBTN.setPrefHeight(40.0);
        borrowBookBTN.setStyle("-fx-font-size: 14px;");

        // button kembali
        Button backBTN = new Button();
        backBTN.setText("Kembali");
        backBTN.setPrefWidth(150.0);
        backBTN.setPrefHeight(40.0);
        backBTN.setStyle("-fx-font-size: 14px;");

        inputLayout.getChildren().addAll(inputIDBukuLayout, inputDurasiLayout);
        buttonLayout.getChildren().addAll(borrowBookBTN, backBTN);

        // action button
        // button available book
        displayAvailableBookBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                displayAvailableBook_GUI objAvailableBook = new displayAvailableBook_GUI();
                try {
                    stage.close();
                    objAvailableBook.start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // button pinjam buku
        borrowBookBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                objStudent.choiceBook(idBukuTxtField.getText(), Integer.parseInt(durasiTxtField.getText()));
            }
        });

        // button kembali
        backBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                StudentMenu_GUI objGUIMenuStudent = new StudentMenu_GUI();
                try {
                    stage.close();
                    objGUIMenuStudent.start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // root layout
        VBox root = new VBox();
        root.setSpacing(40);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(titleTXT, inputLayout, displayAvailableBookBTN, buttonLayout);

        Scene scene = new Scene(root);
        stage.setTitle("Library System - Choice Book");
        stage.setWidth(600);
        stage.setHeight(600);
        stage.setScene(scene);
        stage.show();
    }
}
