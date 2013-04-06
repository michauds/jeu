/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tournoi;

/**
 *
 * @author Équipe Baloney
 */
class RuneFehu extends Rune {

    public RuneFehu() {
        this.setNom("Fehu");   
        this.setValeur(3);
    }

    @Override
    public String toString() {        
       return (Positionnement.HORSJEU == this.getPosition() )? "f" : "F";
       
    }
    
}
