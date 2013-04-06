/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Arrays;
/**
 *
 * @author naddou
 */
public class EquipeMontrealSim2 {

    private static Groupe Dagaaz;
    private static Groupe Eihwaz;
    private static Groupe Jerah;
    private static Groupe Tiwaz;

    private static void initialisserUnePartie(){
        Dagaaz = new Groupe("Dagaaz");
        Eihwaz = new Groupe("Eihwaz");
        Jerah = new Groupe("Jerah");
        Tiwaz = new Groupe("Tiwaz");
        try {
            if (Dagaaz != null) {
                if (!Dagaaz.ajouterMembres(Arrays.asList("Uruz", "Thurisaz", "Raido", "Kaunaan"))) {
                    throw new InitialisationException("Initialisation Invalide de Dagaaz");
                }
            }
            if (Eihwaz != null) {
                if (!Eihwaz.ajouterMembres(Arrays.asList("Gebo", "Wunjo", "Hagalaaz", "Naudiz"))) {
                    throw new InitialisationException("Initialisation Invalide de Eihwaz");
                }
            }
            if (Jerah != null) {
                if (!Jerah.ajouterMembres(Arrays.asList("Isaaz", "Perpo", "Algiz", "Sowilo"))) {
                    throw new InitialisationException("Initialisation Invalide de Jerah");
                }
            }
            if (Tiwaz != null) {
                if (!Tiwaz.ajouterMembres(Arrays.asList("Othalaan", "Ingwaz", "Mannaz", "Berkanan"))) {
                    throw new InitialisationException("Initialisation Invalide de Tiwaz");
                }
            }
        } catch (InitialisationException e) {
            // Logger l'erreur
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        initialisserUnePartie();
    }

}