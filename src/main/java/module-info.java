module com.example.studieadministrationjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.studieadministrationjavafx to javafx.fxml;
    exports com.example.studieadministrationjavafx;
}