/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetjavafx1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Etu
 */
public class ContexteIdentification {
    private Personnes personnes;
    private StringProperty loginUtilisateurConnecte;
    private StringProperty passwordUtilisateurConnecte;
    
    public ContexteIdentification(Personnes personnes){
        this.personnes = personnes;
        loginUtilisateurConnecte = new SimpleStringProperty();
        passwordUtilisateurConnecte = new SimpleStringProperty();
    }
    public Personnes getPersonnes(){
        return personnes;
    }
    public StringProperty LoginUtilisateurConnecteProperty(){
        return loginUtilisateurConnecte;
    }
    public String getLoginUtilisateurConnecte(){
        return loginUtilisateurConnecte.getValue();
    }
    public StringProperty PasswordUtilisateurConnecteProperty(){
        return passwordUtilisateurConnecte;
    }
    public String getPasswordUtilisateurConnecte(){
        return passwordUtilisateurConnecte.getValue();
    }
    public Personne identification(){
        return personnes.identification(loginUtilisateurConnecte.getValue(), passwordUtilisateurConnecte.getValue());
    }
}
