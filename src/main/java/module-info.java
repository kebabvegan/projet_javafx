module com.mycompany.projet_javafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.projet_javafx to javafx.fxml;
    exports com.mycompany.projet_javafx;
}