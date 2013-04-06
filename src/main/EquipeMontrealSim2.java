/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


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
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        File f = new File(nomFichierSauvegarde);
        // TODO code application logic here
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
                //chargerPartie();
                initialisserUnePartie();
                
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
        while(entree.compareToIgnoreCase("e") != 0
                && entree.compareToIgnoreCase("q") != 0) {
            System.out.print("(L)ancer les runer,(E)nregistrer, ou (Q)uitter: ");
            entree = in.next();
            if (entree.equalsIgnoreCase("l")) {
                System.out.println("Lancement des runes!");
            }
        }
        if(entree.equalsIgnoreCase("e")) {
            System.out.println("Enregistrement de la partie");
            SauvegargerPartie();
        }
    }
}
