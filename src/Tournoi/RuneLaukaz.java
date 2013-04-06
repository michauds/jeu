/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tournoi;

/**
 *
 * @author Équipe Baloney
 */
class RuneLaukaz extends Rune {

    public RuneLaukaz() {
        this.setNom("Laukaz");   
        this.setValeur(1);
    }

    @Override
    public String toString() {        
       return (Positionnement.HORSJEU == this.getPosition() )? "l" : "L";
       
    }  
    
}
