package com.mycompany.projetjavafx1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;

import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
/**
 * FXML Controller class
 *
 * @author Etu
 */
public class AccueilController implements Initializable {


    @FXML
    private MenuItem profil;
    @FXML
    private MenuItem config;
    @FXML
    private MenuItem quit;
    
    private ContexteAvatar contexte;
    private ContexteIdentification contexteId;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void profil(ActionEvent event) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Infos");
        alert.setHeaderText("Login : "+ this.contexte.getPersonne().getLogin());
        alert.setContentText("Nom : " + this.contexte.getPersonne().getNom());

        alert.showAndWait();
    }
    
    public void setContexte(ContexteIdentification contexte, ContexteAvatar contexte1){
        this.contexteId = contexte;
        this.contexte = contexte1;
    }

    @FXML
    private void config(ActionEvent event) {
        Personne personneConnectee = contexteId.identification();
        Stage stage = new Stage();
        //Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("nouvelle.fxml"));
        AnchorPane rootLayoot=null;
        try {
            rootLayoot = (AnchorPane) loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //System.out.println("Root:"+rootLayoot);
        NouvelleController controller = loader.getController();
        contexte = new ContexteAvatar(personneConnectee);
        controller.setContexte(contexte);
        Scene scene = new Scene(rootLayoot,1000,600);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    private void quitter(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("You're going to leave");
        alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Platform.exit();System.exit(0);
        } else {
            alert.close();
        }
    }

    private void close(Dialog<Pair<String, String>> dialog) {
        dialog.close();
    }

}
