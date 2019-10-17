/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetjavafx1;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Etu
 */

public class ContexteAvatar {
    
    private Personne personne; 
    
    public ContexteAvatar (Personne personne){
        this.personne = personne;
    }
    
    public StringProperty yeuxProperty(){
        
        return personne.yeuxProperty();
    }
    
    public StringProperty peauProperty(){
        
        return personne.peauProperty();
    }
    
    public IntegerProperty longueurProperty(){
        return personne.longueurProperty();
    }
    
    public IntegerProperty largeurProperty(){
        
        return personne.largeurProperty();
    }
    
    public Personne getPersonne (){
        return this.personne;
    }
    
}
