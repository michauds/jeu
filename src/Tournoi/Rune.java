/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tournoi;

import java.util.Random;

/**
 *
 * @author Équipe Baloney
 */
public abstract class Rune {
    
    String nom;
    Integer valeur;
    Cote face;
    Positionnement Position;

    public Positionnement getPosition() {
        return Position;
    }

    public Cote getFace() {
        return face;
    }

    public String getNom() {
        return nom;
    }

    public Integer getValeur() {
        return valeur;
    }

    protected void setPosition(Positionnement Position) {
        this.Position = Position;
    }

    protected void setFace(Cote face) {
        this.face = face;
    }

    protected void setNom(String nom) {
        this.nom = nom;
    }

    protected void setValeur(Integer valeur) {
        this.valeur = valeur;
    }
    
    
    protected void LancerRune(){        
        /*
         * Cette méthode consiste à définir aléatoirement un Coté et une Position.         
         */
        
        Random random = new Random();

        
        this.setFace( random.nextInt(999999)%2==0 ? Cote.CLAIR : Cote.SOMBRE );
        this.setPosition( random.nextInt(999999)%2==0 ? Positionnement.ENJEU : Positionnement.HORSJEU );        
    }
    
     public abstract String toString();
}
