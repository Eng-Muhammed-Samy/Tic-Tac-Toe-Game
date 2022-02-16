module com.example.demo3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.demo3 to javafx.fxml;
    exports com.example.demo3;
    exports com.example.demo3.singlePlayer.minMax;
    opens com.example.demo3.singlePlayer.minMax to javafx.fxml;
}