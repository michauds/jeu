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
public class Groupe extends Enregistrable{

    private String nomGroupe = "";
    private List<Druide> membres = new ArrayList<>();
    static public final int maximumParticipant = 4;
    int ronde;
    final String ELIMINATION = "ronde d'élimination";
    final String DEMI_F = "demi-final";
    final String FINAL = "FINAL";
    public AnneeReference anneeReference;
    private String seperateur = "#";
    private int debutPositionGroupe;
    
    public Groupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
        String annee = "2013";
        String description = "Tournoi de " + annee;
        this.anneeReference = new AnneeReference(annee, description); 
    }
    public Groupe() {
        this.nomGroupe = "";
        this.anneeReference = new AnneeReference(); 
         for (int i = 0; i < maximumParticipant; i++) {
              membres.add(new Druide());
         }
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
        System.out.println("Groupe: " + nomGroupe + "\t(" + ronde() + ")");
        String points = "Points :\t";
        String noms = "Druides:\t";
        
        for(int i=0; i < membres.size(); i++) {
            points += String.valueOf(membres.get(i).getScore());    
            noms += membres.get(i).getNom();
            if (i+1 != membres.size()) {
                points += "\t\t";
                noms += "\t\t";
            }
        }
        System.out.println(points);
        System.out.println(noms + "\n");
    }
    public String ronde(){
        String ronde = "";
         if(membres.size() >= 3){
            ronde =  "ronde d'élimination";
            
        }else if(membres.size() == 2){
            ronde = "demi-final";
            
        }else if(membres.size() == 1){
            ronde =  "final";
        }else{
            ronde = "eliminer";
        }
        return ronde;
    }
    
    public void afficherDruidesActifs() {
        StringBuilder output = new StringBuilder();
        output.setLength(15);
        String lpoints = "Points :\t";
        String lnoms = "Druides :\t";
        String letat = "Statut :\t";
        String points = "",noms = "",etat = "";
        for(int i=0; i < membres.size(); i++) {
            points += String.valueOf(membres.get(i).getScore());    
            noms += membres.get(i).getNom();       
            if (i+1 != membres.size()) {      
                noms += "\t";
                points += "\t   ";
            }
            if (membres.get(i).getScore() <= 0) {
                etat += "Inactivé ";
            } else {
                etat += " ";
            }
        }
        System.out.print(lpoints);
        output.append(points);
        System.out.println(output);
        System.out.println(String.format("%s %-20s", lnoms,noms));
        System.out.println(String.format("%s %-20s", letat,etat));
    }
    
    @Override
    public String sauvegarder() {
        String ligne = nomGroupe + seperateur + ronde;
        
        for(int i=0; i < membres.size(); i++) {
            Druide unDruide = membres.get(i);
            ligne = ligne + seperateur + unDruide.getNom() + seperateur +
                    unDruide.getScore() + seperateur + unDruide.getNombreAureus() +
                    seperateur + unDruide.isEstEleminer();
        }
        return ligne + seperateur + anneeReference.getAnnee() + seperateur + anneeReference.getDescription() + System.getProperty("line.separator");
    }
    
    @Override
    public void charger(String ligne) {
        int position = ligne.indexOf(seperateur);
        this.nomGroupe = ligne.substring(0, position);
        position++;
        debutPositionGroupe = ligne.indexOf(seperateur, position);
        this.ronde = Integer.parseInt(ligne.substring(position, debutPositionGroupe));
        for(int i=0; i < membres.size(); i++) {
            membres.set(i , chargerGroupe(ligne, debutPositionGroupe+1));
        }
        
        int position2 = ligne.indexOf(seperateur, debutPositionGroupe+1);
        String annee = ligne.substring(debutPositionGroupe+1, position2);
        this.anneeReference.setAnnee(annee);
        
        int position3 = ligne.lastIndexOf(seperateur);
        String description = ligne.substring(position3+1, ligne.length());
        this.anneeReference.setDescription(description);
    }
    private Druide chargerGroupe(String ligne, int positionDebut){
        Druide unDruide = new Druide();
        int position = ligne.indexOf(seperateur, positionDebut+1);
        String nom = ligne.substring(positionDebut, position);
        unDruide.setNom(nom);
        
        int position2 = ligne.indexOf(seperateur, position+1);
        String score = ligne.substring(position+1, position2);
        unDruide.setScore(Integer.parseInt(score));
        
        int position3 = ligne.indexOf(seperateur, position2+1);
        String nombreAureus = ligne.substring(position2+1, position3);
        unDruide.setNombreAureus(Integer.parseInt(nombreAureus));
        
        int position4 = ligne.indexOf(seperateur, position3+1);
        String eliminer = ligne.substring(position3+1, position4);
        if (eliminer.equals("false")){
            unDruide.setEstEleminer(false);
        }else{
            unDruide.setEstEleminer(true);
        }
        debutPositionGroupe = position4;
        return unDruide;
    }
    
    public Druide declarerGagnant() {
        Druide gagnant = null;
        if(ronde().equalsIgnoreCase(ELIMINATION)) {
            /*
             * Vérifier s'il ne reste qu'un seul Druide actif
             */
            int nbActif = 0;
            for(int i=0; i < membres.size(); i++) {
                if(membres.get(i).getScore() > 0) {
                    nbActif++;
                }
            }
            if (nbActif == 1) {
                for(int i=0; i < membres.size(); i++) {
                    if(membres.get(i).getScore() > 0) {
                        gagnant = membres.get(i);
                    }
                }
            }
            /*
             * Vérifier si un membre à atteint plus de 100 pts
             */
            for(int i=0; i < membres.size(); i++) {
                if(membres.get(i).getScore() > 100) {
                    gagnant = membres.get(i);
                }
            }
            
        } else if (ronde().equalsIgnoreCase(DEMI_F)) {
            /*
             * Vérifier s'il ne reste qu'un seul Druide actif
             */
            int nbActif = 0;
            for(int i=0; i < membres.size(); i++) {
                if(membres.get(i).getScore() > 0) {
                    nbActif++;
                }
            }
            if (nbActif == 1) {
                for(int i=0; i < membres.size(); i++) {
                    if(membres.get(i).getScore() > 0) {
                        gagnant = membres.get(i);
                    }
                }
            }
            /*
             * Vérifier si un membre à atteint plus de 100 pts
             */
            for(int i=0; i < membres.size(); i++) {
                if(membres.get(i).getScore() > 200) {
                    gagnant = membres.get(i);
                }
            }
        }
        return gagnant;
    }
}
