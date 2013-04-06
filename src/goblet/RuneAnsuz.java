/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tournoi;

/**
 *
 * @author Équipe Baloney
 */
class RuneAnsuz extends Rune {

    public RuneAnsuz() {
        this.setNom("Ansuz");   
        this.setValeur(2);
    }

   @Override
    public String toString() {        
       return (Positionnement.HORSJEU == this.getPosition() )? "a" : "A";
       
    } 
    
}
