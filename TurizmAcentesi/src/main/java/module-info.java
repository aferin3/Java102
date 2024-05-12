module com.javafx.turizmacentesi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.javafx.turizmacentesi to javafx.fxml;
    exports com.javafx.turizmacentesi;
    exports Model;
    opens Model to javafx.fxml;
}