/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author naddou
 */
public class Groupe {

    private String nomGroupe;
    private List<Druide> membres = new ArrayList<>();
    static public final int maximumParticipant = 4;
    int ronde;
    final String ELIMINATION = "ronde d'élimination";
    final String DEMI_F = "demi-final";
    final String FINAL = "FINAL";
    
    public Groupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public List<Druide> getMembres() {
        return membres;
    }

    public void setMembres(ArrayList<Druide> membres) {
        this.membres = membres;
    }

    public boolean ajouterMembre(Druide unDruide) {

        if (membres != null && membres.size() < 4) {
            return membres.add(unDruide);
        }
        return false;
    }

    public boolean ajouterMembres(List<String> nomDesMembres, int points) {
        boolean operationReussit = true;
        if (!nomDesMembres.isEmpty()) {
            for (int i = 0; i < nomDesMembres.size(); i++) {
                if (membres != null && membres.size() < 4) {
                    if (!membres.add(new Druide(nomDesMembres.get(i), points))) {
                        operationReussit = false;
                    }
                } else {
                    operationReussit = false;
                }
            }
        }
        return operationReussit;
    }
    
    public void afficherScores() {
        System.out.println("Groupe: " + nomGroupe);
        String points = "Points: ";
        String noms = "Druides: ";
        
        for(int i=0; i < membres.size(); i++) {
            points += String.valueOf(membres.get(i).getScore());    
            noms += membres.get(i).getNom();
            if (i+1 != membres.size()) {
                points += "\t";
                noms += "\t";
            }
        }
        System.out.println(points);
        System.out.println(noms + "\n");
    }
     public void afficherEtapeGroupe(){
        
        if(membres.size() >= 3){
            System.out.println("Groupe : " + nomGroupe + "ronde d'élimination");
            
        }else if(membres.size() == 2){
            System.out.println("Groupe : " + nomGroupe + "demi-final");
        }else if(membres.size() == 1){
            System.out.println("Groupe : " + nomGroupe + "final");
        }else{
            System.out.println("Groupe : " + nomGroupe + "eliminer");
        }
        if(!membres.isEmpty()){
            System.out.println("points : ");
            for(int i=0; i<membres.size(); i++){
                System.out.println( membres.get(i).getScore() + "    ");  
            }
            System.out.println("druides : ");
             for(int i=0; i<membres.size(); i++){
                System.out.println( membres.get(i).getNom() + "   ");  
            }
        }
    }
}
