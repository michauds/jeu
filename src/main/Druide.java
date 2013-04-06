/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author naddou
 */
public class Druide {
    
    private String nom;
    private boolean estEleminer = false;
    private int score;
    private int nombreAureus = 0;

    public Druide(String nom, int score){
        this.nom = nom;
        this.score = score;
    }
    
    public Druide(String nom, int score, int nombreAureus){
        this.nom = nom;
        this.score = score;
        this.nombreAureus = nombreAureus;
    }
        
    public void setEstEleminer(boolean estEleminer) {
        this.estEleminer = estEleminer;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setNombreAureus(int nombreAureus) {
        this.nombreAureus = nombreAureus;
    }
    
    public String getNom() {
        return nom;
    }

    public boolean isEstEleminer() {
        return estEleminer;
    }

    public int getScore() {
        return score;
    }

    public int getNombreAureus() {
        return nombreAureus;
    }
}
