/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetjavafx1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
 
public class YeuxDAO {
 
    public static ObservableList<String> getYeuxList() {
        String bleu = new String("bleu");
        String vert = new String("vert");
        String marron = new String("marron");
 
        ObservableList<String> list //
                = FXCollections.observableArrayList(bleu, vert, marron);
 
        return list;
    }
    
}

