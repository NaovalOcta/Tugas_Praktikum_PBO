package org.example.tugas_modul6;

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

public class returnBook_GUI extends Application {
    public static void dataResponse(int response) {
        if (response == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText("Anda belum meminjam buku");
            alert.setContentText("Silahkan meminjam buku terlebih dahulu agar dapat menggunakan fitur ini.");
            alert.showAndWait();

        } else if (response == 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informasi");
            alert.setHeaderText("Buku berhasil dikembalikan");
            alert.setContentText("Anda telah berhasil mengembalikan buku.");
            alert.showAndWait();
            try {
                Stage currentStage = (Stage) alert.getDialogPane().getScene().getWindow();
                currentStage.close();

                StudentMenu_GUI objGUIStudentMenu = new StudentMenu_GUI();
                objGUIStudentMenu.start(new Stage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

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
        titleTXT.setText("Mengembalikan Buku");
        titleTXT.setTextAlignment(TextAlignment.CENTER);
        titleTXT.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

        // input id buku layout HBox
        HBox inputIDBukuLayout = new HBox();
        inputIDBukuLayout.setAlignment(Pos.TOP_CENTER);
        inputIDBukuLayout.setSpacing(10);

        // button layout HBox
        HBox buttonLayout = new HBox();
        buttonLayout.setAlignment(Pos.TOP_CENTER);
        buttonLayout.setSpacing(10);

        Label idBukuLabel = new Label();
        idBukuLabel.setText("Buku (urutan nomor)");
        idBukuLabel.setAlignment(Pos.CENTER);
        idBukuLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));

        TextField idBukuTxtField = new TextField();
        idBukuTxtField.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        idBukuTxtField.setAlignment(Pos.TOP_LEFT);
        idBukuTxtField.setPromptText("Masukkan urutan nomor buku yang ingin dikembalikan");

        inputIDBukuLayout.getChildren().addAll(idBukuLabel, idBukuTxtField);

        // button display available book
        Button displayBorrowedBookBTN = new Button();
        displayBorrowedBookBTN.setText("Display Borrowed Book");
        displayBorrowedBookBTN.setPrefWidth(250.0);
        displayBorrowedBookBTN.setPrefHeight(40.0);
        displayBorrowedBookBTN.setStyle("-fx-font-size: 14px;");

        // button pinjam buku
        Button borrowBookBTN = new Button();
        borrowBookBTN.setText("Kembalikan");
        borrowBookBTN.setPrefWidth(150.0);
        borrowBookBTN.setPrefHeight(40.0);
        borrowBookBTN.setStyle("-fx-font-size: 14px;");

        // button kembali
        Button backBTN = new Button();
        backBTN.setText("Back");
        backBTN.setPrefWidth(150.0);
        backBTN.setPrefHeight(40.0);
        backBTN.setStyle("-fx-font-size: 14px;");

        inputLayout.getChildren().addAll(inputIDBukuLayout);
        buttonLayout.getChildren().addAll(borrowBookBTN, backBTN);

        // action button
        // button available book
        displayBorrowedBookBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    stage.close();
                    displayBorrowedBook_GUI objGUIDisplayBorrowedBook = new displayBorrowedBook_GUI();
                    objGUIDisplayBorrowedBook.start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // button pinjam buku
        borrowBookBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Student objStudent = new Student("", "", "", "");
                objStudent.returnBook(Integer.parseInt(idBukuTxtField.getText()));
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
        root.getChildren().addAll(titleTXT, inputLayout, displayBorrowedBookBTN, buttonLayout);

        Scene scene = new Scene(root);
        stage.setTitle("Library System - Return Book");
        stage.setWidth(600);
        stage.setHeight(600);
        stage.setScene(scene);
        stage.show();
    }
}
