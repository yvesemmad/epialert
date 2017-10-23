package com.yed.classes;

import java.io.Serializable;

/**
 * Created by emmanuel on 23/10/2017.
 */
public class Aire extends District implements Serializable {

    private String libelle;
    private District district;

    public Aire() {

    }

    @Override
    public String getLibelle() {
        return libelle;
    }

    @Override
    public Aire setLibelle(String libelle) {
        this.libelle = libelle;
        return this;
    }

    public District getDistrict() {
        return district;
    }

    public Aire setDistrict(District district) {
        this.district = district;
        return this;
    }
}
