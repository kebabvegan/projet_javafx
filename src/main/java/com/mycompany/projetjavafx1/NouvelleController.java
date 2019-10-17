/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetjavafx1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Etu
 */
public class NouvelleController implements Initializable {
    


    
    ContexteAvatar contexte;
    @FXML
    private ComboBox<String> combobox;
    @FXML
    private Button suivant;
    @FXML
    private Canvas canvas;
    
    private GraphicsContext gc;
    @FXML
    private Slider largeur;
    @FXML
    private Slider hauteur;
    @FXML
    private CheckBox moustache;
    @FXML
    private Button erase;
    @FXML
    private ListView<String> listview;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.combobox.setItems(
        FXCollections.observableArrayList("BLUE", "GREEN", "BLACK"));
        this.hauteur.setMin(120);
        this.hauteur.setMax(140);
        this.largeur.setMin(120);
        this.largeur.setMax(140);
        this.hauteur.setValue(120);
        this.largeur.setValue(120);
        this.listview.setItems(
        FXCollections.observableArrayList("WHITE", "BLACK", "BROWN"));
        
        
    }   
    
    public void draw (){
        
        gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 500, 500);
        if (combobox.getValue() == "BLUE"){
            gc.setFill(Color.BLUE);
            gc.fillOval(200, 60, 30,30);
            gc.fillOval(240, 60, 30, 30);
        }
        else if (combobox.getValue() == "GREEN"){
            gc.setFill(Color.GREEN);
            gc.fillOval(200, 60, 30, 30);
            gc.fillOval(240, 60, 30, 30);
        }
        else if (combobox.getValue() == "BLACK"){
            gc.setFill(Color.BROWN);
            gc.fillOval(200, 60, 30, 30);
            gc.fillOval(240, 60, 30, 30);
        }
        gc.setStroke(Color.BLACK);
        gc.strokeLine(215, 140, 265, 140);
        gc.strokeOval(180, 50, largeur.getValue(), hauteur.getValue());
    }
    
    
    
    public void setContexte(ContexteAvatar contexte){
        this.contexte = contexte;
        contexte.yeuxProperty().bindBidirectional(combobox.valueProperty());
        contexte.yeuxProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed(ObservableValue<? extends String> observable,String oldValue, String newValue){
            draw();
        }
        
        });
        contexte.largeurProperty().bindBidirectional(largeur.valueProperty());
        contexte.largeurProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue ov, Object t, Object t1) {
                draw();
            }
        });
        contexte.longueurProperty().bindBidirectional(hauteur.valueProperty());
        contexte.longueurProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue ov, Object t, Object t1) {
                draw();
            }
        });
    }

    @FXML
    private void afficher(ActionEvent event) {
        System.out.println(contexte.getPersonne().getYeux());
    }

    @FXML
    private void effacer(ActionEvent event) {
        gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, 500, 500);
    }

    @FXML
    private void drawMoustache(ActionEvent event) {
        gc = canvas.getGraphicsContext2D();
        if (moustache.isSelected()){
            gc.strokeLine(230, 135, 250, 135);          
        }
        else{
            gc.clearRect(230, 135, 25, 1);
        }
        
    }

    @FXML
    private void peau(ListView.EditEvent<T> event) {
    }
    
}
