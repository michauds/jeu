/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tournoi;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author Équipe Baloney
 */
public class Gobelet {
   
    private ArrayList<Rune> contenu;

    public Gobelet() {
        
        this.contenu = new ArrayList();
        
        this.contenu.add(new RuneLaukaz());
        this.contenu.add(new RuneLaukaz());
        this.contenu.add(new RuneLaukaz());
        this.contenu.add(new RuneAnsuz());
        this.contenu.add(new RuneAnsuz());
        this.contenu.add(new RuneAnsuz());
        this.contenu.add(new RuneAnsuz());
        this.contenu.add(new RuneFehu());
        this.contenu.add(new RuneFehu());
        this.contenu.add(new RuneFehu());
        
    }
    
    
    
    public ArrayList<Rune> LancerGobelet(){
        
        /*
         * Lancer chaque rune du contenu à l'aide d'un itérateur
         */
        ListIterator<Rune> iter = contenu.listIterator();
        for( int i=0; i<contenu.size(); i++){
            iter.next().LancerRune();            
        }
        
        return this.contenu;
        
    }    
            
}
