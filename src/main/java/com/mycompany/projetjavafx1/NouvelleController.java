/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetjavafx1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TitledPane;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

/**
 * FXML Controller class
 *
 * @author Etu
 */
public class NouvelleController implements Initializable {
    ContexteIdentification contexte;
    @FXML
    public Canvas canvasPersonnage;
    @FXML
    private ComboBox<String> color;
    @FXML
    private ComboBox<String> colorpo;
    private int drawshape;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.draw(); 
        this.startColors();
    }    

    private void draw() {
      GraphicsContext gc = this.canvasPersonnage.getGraphicsContext2D();
      gc.setStroke(Color.BLACK);
      gc.setFill(Color.BLACK);
      gc.strokeOval(200, 50, 120, 130);
      gc.fillOval(220, 90, 10, 20);
      gc.fillOval(280 ,90, 10, 20);
      gc.strokeArc(230, 100, 50, 60, 180, 180, ArcType.OPEN);
      gc.strokeArc(230, 100, 50, 60, 180, 180, ArcType.ROUND);
    }
    
    private void startColors() {
        color.getItems().addAll("Blanc", "Rose");
        color.valueProperty().addListener((ObservableValue<? extends String> obs, String oldValue, String newValue) -> {
            switch (newValue) {
                case "Blanc":
                    NouvelleController.this.drawshape = 0;
                    break;
                case "Rose":
                    NouvelleController.this.drawshape = 1;
                    break;
                default:
                    break;
            }
            draw();
        });
    }
    
   
    
    public void setContexte(ContexteIdentification contexte){
        this.contexte = contexte;
    }


    @FXML
    private void selectBarbe(ActionEvent event) {
        
    }

    @FXML
    private void selectmb(ActionEvent event) {
    }

    @FXML
    private void selectrase(ActionEvent event) {
    }


    @FXML
    private void selectBleu(ActionEvent event) {
    }

    @FXML
    private void selectMarron(ActionEvent event) {
    }

    @FXML
    private void selectVerts(ActionEvent event) {
    }

    @FXML
    private void faceHaut(DragEvent event) {
        
    }

    @FXML
    private void faceLarge(DragEvent event) {
    }

    @FXML
    private void lunettesOui(ActionEvent event) {
        
    }

    @FXML
    private void lunettesNon(ActionEvent event) {
        
    }

    @FXML
    private void selectMoustache(MouseEvent event) {
      
    }
    
}
