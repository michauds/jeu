/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author naddou
 */
public class Groupe {

    private String nomGroupe;
    private List<Druide> mombres = new ArrayList<>();
    static public final int maximumParticipant = 4;

    public Groupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public List<Druide> getMombres() {
        return mombres;
    }

    public void setMombres(ArrayList<Druide> mombres) {
        this.mombres = mombres;
    }

    public boolean ajouterMembre(Druide unDruide) {

        if (mombres != null && mombres.size() < 4) {
            return mombres.add(unDruide);
        }
        return false;
    }

    public boolean ajouterMembres(List<String> nomDesMembres) {
        boolean operationReussit = true;
        if (!nomDesMembres.isEmpty()) {
            for (int i = 0; i < nomDesMembres.size(); i++) {
                if (mombres != null && mombres.size() < 4) {
                    if (!mombres.add(new Druide(nomDesMembres.get(i), 0))) {
                        operationReussit = false;
                    }
                } else {
                    operationReussit = false;
                }
            }
        }
        return operationReussit;
    }
}
