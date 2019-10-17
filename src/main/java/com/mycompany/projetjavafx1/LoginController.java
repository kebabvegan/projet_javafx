/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetjavafx1;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Etu
 */
public class LoginController implements Initializable {

    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    
    ContexteIdentification contexte;
    
    @FXML
    void processCancel(ActionEvent event){
        login.textProperty().set("");
        password.textProperty().set("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void setContexte(ContexteIdentification contexte){
        System.out.println(contexte+" "+login+" "+contexte.LoginUtilisateurConnecteProperty());
        this.contexte = contexte;
        contexte.LoginUtilisateurConnecteProperty().bind(login.textProperty());
        contexte.PasswordUtilisateurConnecteProperty().bind(password.textProperty());
    }
    
    @FXML
    void processOK(ActionEvent event){
        System.out.println("Le login est "+contexte.LoginUtilisateurConnecteProperty().getValue()+
                " et le password est "+contexte.PasswordUtilisateurConnecteProperty().getValue());
        Personne personneConnectee = contexte.identification();
        if (personneConnectee != null){
            Stage stage = (Stage)this.login.getScene().getWindow(); //Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
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
            System.out.println("Controller:"+controller);
            ContexteAvatar contexte = new ContexteAvatar(personneConnectee);
            controller.setContexte(contexte);
            Scene scene = new Scene(rootLayoot,1000,600);
            stage.setScene(scene);
            stage.centerOnScreen();
        }
    
    }
    /**
     * Initializes the controller class.
     */
    
    

    
}
