/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author naddou
 */
public class Enregistrement implements IEnregistrement{
    @Override
    public void sauvegarderFichier(String Fichier, List<Enregistrable> listObjetc){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(Fichier), Integer.SIZE);
            
            for(int i=0; i < listObjetc.size(); i++) {
                String ligne = listObjetc.get(i).sauvegarder();
                out.write(ligne);
            }
            out.close();
        } catch (IOException e) {
            
        }
        
        
    }
    @Override
    public void chargerFichier(String Fichier, List<Enregistrable> listObjetc){
        
    } 
}
