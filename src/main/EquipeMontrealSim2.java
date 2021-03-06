/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Tournoi.CalculLancerRune;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import Tournoi.Gobelet;
import Tournoi.Positionnement;
import Tournoi.Rune;
import java.util.Iterator;


/**
 *
 * @author naddou
 */
public class EquipeMontrealSim2 {

    private static Groupe Dagaaz;
    private static Groupe Eihwaz;
    private static Groupe Jerah;
    private static Groupe Tiwaz;
    
    private final static String nomFichierSauvegarde = "SauvegardePartie.txt";

    private static void initialisserUnePartie() {
        Dagaaz = new Groupe("Dagaaz");
        Eihwaz = new Groupe("Eihwaz");
        Jerah = new Groupe("Jerah");
        Tiwaz = new Groupe("Tiwaz");
        try {
            if (Dagaaz != null) {
                if (!Dagaaz.ajouterMembres(Arrays.asList("Uruz", "Thurisaz", "Raido", "Kaunaan"), 20)) {
                    throw new InitialisationException("Initialisation Invalide de Dagaaz");
                }
            }
            if (Eihwaz != null) {
                if (!Eihwaz.ajouterMembres(Arrays.asList("Gebo", "Wunjo", "Hagalaaz", "Naudiz"), 20)) {
                    throw new InitialisationException("Initialisation Invalide de Eihwaz");
                }
            }
            if (Jerah != null) {
                if (!Jerah.ajouterMembres(Arrays.asList("Isaaz", "Perpo", "Algiz", "Sowilo"), 0)) {
                    throw new InitialisationException("Initialisation Invalide de Jerah");
                }
            }
            if (Tiwaz != null) {
                if (!Tiwaz.ajouterMembres(Arrays.asList("Othalaan", "Ingwaz", "Mannaz", "Berkanan"), 20)) {
                    throw new InitialisationException("Initialisation Invalide de Tiwaz");
                }
            }
        } catch (InitialisationException e) {
            // Logger l'erreur
        }
    }

    private static void jouerRonde(Groupe groupe) {
        System.out.println("Groupe: " + groupe.getNomGroupe());
        String points = "Points :\t";
        String noms = "Druides:\t";
        String surface = "Surface:\t";
        String tombes = "Tombées:\t";
        String v_surface = "Valeur S:\t";
        String v_tombes = "Valeurs T:\t";
        for(int i=0; i < groupe.getMembres().size(); i++) {
           
            points += String.valueOf(groupe.getMembres().get(i).getScore());    
            noms += groupe.getMembres().get(i).getNom();           
            Gobelet goblet = new Gobelet();
            ArrayList<Rune> runes = goblet.LancerGobelet();
            
            int diffPoints = CalculLancerRune.calculPointTourDeRonde(runes);
            
            for(int j = 0; j < runes.size(); j++) {
                if(runes.get(j).getPosition() == Positionnement.ENJEU) {
                    surface += runes.get(j).toString();
                    v_surface += runes.get(j).getValeur().toString();
                } else {
                    tombes += runes.get(j).toString();
                    v_tombes += runes.get(j).getValeur().toString();
                }
            }
            
            surface += "\t";
            tombes += "\t";
            noms += "\t";
            points += "\t";
            v_surface += "\t";
            v_tombes += "\t";
        }
        
        
        System.out.println(points);
        System.out.println(noms);
        System.out.println(surface);
        System.out.println(v_surface);
        System.out.println(tombes);
        System.out.println(v_tombes);
        
    }
    
    
        /*
        
        for(int i=0; i < membres.size(); i++) {
            
            if (i+1 != membres.size()) {
                points += "\t\t";
                noms += "\t\t";
            }
        }
        
    */
        
    private static void afficherScores() {
        Dagaaz.afficherScores();
        Eihwaz.afficherScores();
        Jerah.afficherScores();
        Tiwaz.afficherScores();
    }

    private static void afficherDruidesActifs() {
        Dagaaz.afficherDruidesActifs();
        Eihwaz.afficherDruidesActifs();
        Jerah.afficherDruidesActifs();
        Tiwaz.afficherDruidesActifs();
    }

    private static void SauvegargerPartie(){
        List<Enregistrable> ListEnregistarble = new ArrayList<>();
        ListEnregistarble.add((Enregistrable) Dagaaz);
        ListEnregistarble.add((Enregistrable) Eihwaz);
        ListEnregistarble.add((Enregistrable) Jerah);
        ListEnregistarble.add((Enregistrable) Tiwaz);
        Enregistrement.sauvegarderFichier(nomFichierSauvegarde, ListEnregistarble);
    }
    
        private static void chargerPartie(){
        List<Enregistrable> ListEnregistarble = new ArrayList<>();
        ListEnregistarble.add((Enregistrable) new Groupe());
        ListEnregistarble.add((Enregistrable) new Groupe());
        ListEnregistarble.add((Enregistrable) new Groupe());
        ListEnregistarble.add((Enregistrable) new Groupe());
        Enregistrement.chargerFichier(nomFichierSauvegarde, ListEnregistarble);
        Dagaaz = (Groupe) ListEnregistarble.get(0);
        Eihwaz = (Groupe) ListEnregistarble.get(1);
        Jerah = (Groupe) ListEnregistarble.get(2);
        Tiwaz = (Groupe) ListEnregistarble.get(3);
        afficherScores();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        File f = new File(nomFichierSauvegarde);
        /*
         * Vérifier s'il existe un fichier de jeu 
         */
        if (f.exists()) {
            System.out.println("Il existe une partie enregistrée.");
            System.out.println("Voulez-vous rétablir la partie enregistrée? (O/N)");
            
            String rep = "a";
            while(rep.compareToIgnoreCase("o") != 0
                    && rep.compareToIgnoreCase("n") != 0) {
                rep = in.next();                       
            }
            if(rep.equalsIgnoreCase("o")) {
                System.out.println("Chargement en cours");
                chargerPartie();
                
            } else {
                System.out.println("Création d'une nouvelle partie");
                initialisserUnePartie();
            }
        
        } else {
            System.out.println("Création d'une nouvelle partie");
            initialisserUnePartie();
        }
        //afficherScores();
        //Dagaaz.afficherEtapeGroupe();
        
        String entree = " ";
        /*
         * GAME LOOP
         */
        while(entree.compareToIgnoreCase("e") != 0
                && entree.compareToIgnoreCase("q") != 0) {
            
            System.out.print("(L)ancer les runer,(E)nregistrer, ou (Q)uitter: ");
            entree = in.next();
            /*
             * JOUER UNE RONDE
             */
            if (entree.equalsIgnoreCase("l")) {
                
                jouerRonde(Dagaaz);
            
            } /* FIN D'UNE RONDE */
        } /* FIN GAME LOOP */
        
        
        if(entree.equalsIgnoreCase("e")) {
            System.out.println("Enregistrement de la partie");
            SauvegargerPartie();
        }
    }
}
