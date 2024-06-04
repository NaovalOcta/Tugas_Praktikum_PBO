module org.example.tugas_modul6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens org.example.tugas_modul6 to javafx.fxml;
    opens data to javafx.base;
    opens books to javafx.base;
    exports org.example.tugas_modul6;
}