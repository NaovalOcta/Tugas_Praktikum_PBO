package org.example.tugas_modul6;

import books.Book;
import com.main.LibrarySystem;
import data.Admin;
import data.Student;
import data.User;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class displayAvailableBook_GUI extends Application {
    private TableView table = new TableView();
    private User objUser = new User();

    @Override
    public void start(Stage stage) throws Exception {
        final Label label = new Label("Daftar Buku yang Tersedia");
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font("Tahoma", 30));

        table.setEditable(false);

        // kode improvisasi
        table.setPrefHeight(300);
        table.setPrefWidth(350);

        TableColumn<Book, String> namaBukuCol = new TableColumn<>("Nama Buku");
        TableColumn<Book, String> idBukuCol = new TableColumn<>("ID Buku");
        TableColumn<Book, String> authorCol = new TableColumn<>("Author");
        TableColumn<Book, String> kategoriCol = new TableColumn<>("Kategori");
        TableColumn<Book, String> stockCol = new TableColumn<>("Stock");

        idBukuCol.setCellValueFactory(
                new PropertyValueFactory<>("bookId")
        );
        namaBukuCol.setCellValueFactory(
                new PropertyValueFactory<>("title")
        );
        authorCol.setCellValueFactory(
                new PropertyValueFactory<>("author")
        );
        kategoriCol.setCellValueFactory(
                new PropertyValueFactory<>("category")
        );
        stockCol.setCellValueFactory(
                new PropertyValueFactory<>("stock")
        );

        table.getColumns().addAll(idBukuCol, namaBukuCol, authorCol, kategoriCol, stockCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        table.setItems(FXCollections.observableArrayList(objUser.getBookList()));

        Button backButton = new Button();
        backButton.setText("Back");
        // set width button
        backButton.setPrefWidth(200.0);
        // set height button
        backButton.setPrefHeight(40.0);
        // set font size
        backButton.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // BUTTON ACTION
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                LibrarySystem objLibrarySystem = new LibrarySystem();
                String nimStudentLogin = objLibrarySystem.getNimStudentListHolder();
                if (nimStudentLogin == null) {
                    stage.close();
                    adminMenu_GUI objGUIMenuAdmin = new adminMenu_GUI();
                    try {
                        objGUIMenuAdmin.start(new Stage());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    stage.close();
                    StudentMenu_GUI objGUIMenuStudent = new StudentMenu_GUI();
                    try {
                        objGUIMenuStudent.start(new Stage());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        final VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(8);
        vbox.setPadding(new Insets(20, 10, 10, 10));
        vbox.getChildren().addAll(label, table, backButton);

        Scene scene = new Scene(vbox);
        stage.setTitle("Library System - Display Available Book");
        stage.setWidth(600);
        stage.setHeight(600);
        stage.setScene(scene);
        stage.show();
    }
}
