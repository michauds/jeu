/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author naddou
 */
public class AnneeReference {

    public String annee;
    public String description;

    AnneeReference(String annee, String description) {
        this.annee = annee;
        this.description = description;
    }
    
    public String getAnnee() {
        return annee;
    }

    public String getDescription() {
        return description;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
