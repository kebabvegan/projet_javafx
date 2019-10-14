package com.mycompany.projetjavafx1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.layout.BorderPane;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Login.fxml"));
            BorderPane rootLayoot = (BorderPane) fxmlLoader.load();
            LoginController controller = fxmlLoader.getController();
            ContexteIdentification contexte = new ContexteIdentification(new Personnes());
            controller.setContexte(contexte);
            Scene scene = new Scene(rootLayoot);
            stage.setScene(scene);
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
            
        }
        
    }

//    static void setRoot(String fxml) throws IOException {
//        scene.setRoot(loadFXML(fxml));
//    }
//
//    private static Parent loadFXML(String fxml) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Login.fxml"));
//        return fxmlLoader.load();
//    }

    public static void main(String[] args) {
        launch(args);
    }

}