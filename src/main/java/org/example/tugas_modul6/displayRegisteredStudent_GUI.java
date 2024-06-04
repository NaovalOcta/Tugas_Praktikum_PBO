package org.example.tugas_modul6;

import data.Admin;
import data.Student;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class displayRegisteredStudent_GUI extends Application {
    private TableView table = new TableView();

    @Override
    public void start(Stage stage) throws Exception {
        final Label label = new Label("Daftar Mahasiswa");
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font("Tahoma", 30));

        table.setEditable(false);

        // kode improvisasi
        table.setPrefHeight(300);
        table.setPrefWidth(350);

        TableColumn<Student, String> nameCol = new TableColumn<>("Nama");
        TableColumn<Student, String> facultyCol = new TableColumn<>("Fakultas");
        TableColumn<Student, String> nimCol = new TableColumn<>("NIM");
        TableColumn<Student, String> programStudiCol = new TableColumn<>("Program Studi");

        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );
        facultyCol.setCellValueFactory(
                new PropertyValueFactory<>("faculty")
        );
        nimCol.setCellValueFactory(
                new PropertyValueFactory<>("nim")
        );
        programStudiCol.setCellValueFactory(
                new PropertyValueFactory<>("programStudi")
        );

        table.getColumns().addAll(nameCol, nimCol, facultyCol, programStudiCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        table.setItems(FXCollections.observableArrayList(Admin.getStudentList()));

        Button backButton = new Button();
        backButton.setText("Back");
        // set width button
        backButton.setPrefWidth(200.0);
        // set height button
        backButton.setPrefHeight(40.0);
        // set font size
        backButton.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                adminMenu_GUI objGUIMenuAdmin = new adminMenu_GUI();
                stage.close();
                try {
                    objGUIMenuAdmin.start(new Stage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        final VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(8);
        vbox.setPadding(new Insets(20, 10, 10, 10));
        vbox.getChildren().addAll(label, table, backButton);

        Scene scene = new Scene(vbox);
        stage.setTitle("Library System - Display Registered Student");
        stage.setWidth(600);
        stage.setHeight(600);
        stage.setScene(scene);
        stage.show();
    }
}
