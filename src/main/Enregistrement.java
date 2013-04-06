/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author naddou
 */
public class Enregistrement implements IEnregistrement{
    @Override
    public void sauvegarderFichier(String Fichier, List<Enregistrable> listObjetc){
        for(int i=0; i < listObjetc.size(); i++) {
            String ligne = listObjetc.get(i).sauvegarder();
        }
    }
    @Override
    public void chargerFichier(String Fichier, List<Enregistrable> listObjetc){
        
    } 
}
