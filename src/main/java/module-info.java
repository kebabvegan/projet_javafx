module com.mycompany.projetjavafx1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.projetjavafx1 to javafx.fxml;
    exports com.mycompany.projetjavafx1;
}