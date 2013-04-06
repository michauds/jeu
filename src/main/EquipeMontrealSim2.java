/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        //ListEnregistarble.clear();
        //Enregistrement.chargerFichier(nomFichierSauvegarde, ListEnregistarble);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        initialisserUnePartie();
        afficherScores();
        //Dagaaz.afficherEtapeGroupe();
        afficherDruidesActifs();
        SauvegargerPartie();
    }
}
