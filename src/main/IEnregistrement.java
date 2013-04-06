/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;

/**
 *
 * @author naddou
 */
public interface IEnregistrement {
    
    public void sauvegarderFichier(String Fichier, List<Enregistrable> listObjetc);
    public void chargerFichier(String Fichier, List<Enregistrable> listObjetc);
}
