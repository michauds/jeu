/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author naddou
 */
public class Enregistrement{
    
    /**
     * Fonction a appeller pour sauvegarder les données dans un fichier
     * Il est important que les objets à sauvegarder aient implémentés la 
     * fonction sauvegarder()
     * 
     * @param Fichier Lien vers le fichier 
     * @param listObjetc Liste d'objets ayant la fonction "sauvegarder()" 
     *  qui doivent être écrits vers un fichier
     */
    public static void sauvegarderFichier(String Fichier, List<Enregistrable> listObjetc) {
        
        try (BufferedWriter out = new BufferedWriter(new FileWriter(Fichier), Integer.SIZE)) {
            for (int i = 0; i < listObjetc.size(); i++) {
                String ligne = listObjetc.get(i).sauvegarder();
                out.write(ligne);
            }
        } catch (IOException e) {
            System.out.println("Erreur de sauvegarde des données.");
            
        }
    }
    
    /**
     * Fonction a appeller pour sauvegarder les données dans un fichier
     * Il est important que les objets à sauvegarder aient implémentés la 
     * fonction sauvegarder() 
     * 
     * @param Fichier
     * @param listObjetc 
     */
    public static void chargerFichier(String Fichier, List<Enregistrable> listObjetc){

        //String ligne = "Dagaaz#0#Uruz#20#0#false#Thurisaz#20#0#false#Raido#20#0#false#Kaunaan#20#0#false#2013#Tournoi de 2013";
        //listObjetc.get(0).charger(ligne);
        
        try (BufferedReader in = new BufferedReader(new FileReader(Fichier), Integer.SIZE)) {
            String ligne;
            int iterateur = 0;
            while((ligne = in.readLine()) != null) {
                listObjetc.get(iterateur).charger(ligne);
                iterateur ++;
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Erreur de chargement de partie.");
            // Ajout code pour créer une nouvelle partie
        }

    } 
}
