/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculLancerRune;

import java.util.*;
import jeurune.druide.rune.Positionnement;
import jeurune.druide.rune.Rune;
import jeurune.gobelet.Gobelet;

/**
 *
 * @author Lomscroft
 */
public class CalculLancerRune {
    
    public static int calculPointTourDeRonde(List<Rune> list) {
                
        int somme = 0;
        
        for (int i = 0; i < list.size(); ++i) {
            Rune rune = list.get(i);
            
            if (rune.getPosition().equals(Positionnement.ENJEU)) {
                somme += rune.getValeur();                 
            }
        }
        
        return somme;
    }
    
    public static int calculPointRuneTombe(List<Rune> list) {
       
       
        int somme = 0;
        
        for (int i = 0; i < list.size(); ++i) {
            Rune rune = list.get(i);
            
            if (rune.getPosition().equals(Positionnement.HORSJEU)) {
                somme += rune.getValeur();                 
            }
        }
        
        return somme;
    }
    
}
