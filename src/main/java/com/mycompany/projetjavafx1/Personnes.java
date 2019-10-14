/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetjavafx1;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Etu
 */
public class Personnes {
    
    private final ObservableList<Personne> liste;
    
    public Personnes(List<Personne> liste){
        this.liste = FXCollections.observableArrayList(liste);
    }
    public Personnes(){
        this.liste = FXCollections.observableArrayList();
        this.liste.add(new Personne("p", "to", "Paul Durant", "5, rue du pont", "", "0606060606"));
        this.liste.add(new Personne("paul.dupont", "tatata", "Paul Dupont", "5, rue du pont", "", "0606060606"));
    }
    
    public ObservableList<Personne> getListe(){
        return liste;
    }
    
    public Personne identification(String login, String password){
        for (Personne p: liste)
            if (p.checkPassword(login, password)) return p;
        return null;
    }
}
