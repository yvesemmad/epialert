package com.yed.classes;

import java.io.Serializable;
import java.util.List;

/**
 * Created by emmanuel on 23/10/2017.
 */
public class District extends Entitee implements Serializable {

    private String libelle;
    private List<Aire> aires;

    public District() {
    }

    public String getLibelle() {
        return libelle;
    }

    public District setLibelle(String libelle) {
        this.libelle = libelle;
        return this;
    }

    public List<Aire> getAires() {
        return aires;
    }

    public District setAires(List<Aire> aires) {
        this.aires = aires;
        return this;
    }

}
