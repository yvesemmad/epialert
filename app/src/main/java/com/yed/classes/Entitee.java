package com.yed.classes;

import java.io.Serializable;

/**
 * Created by emmanuel on 23/10/2017.
 */
public class Entitee implements Serializable {

    private Long id;
    private String designation;


    public Entitee() {

    }
    public Entitee(Long id) {
        this.id = id;
    }
    public Entitee(String designation) {
        this.designation = designation;
    }
    public Entitee(Long id, String designation) {
        this.id = id;
        this.designation = designation;
    }

    public Long getId() {
        return id;
    }

    public Entitee setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDesignation() {
        return designation;
    }

    public Entitee setDesignation(String designation) {
        this.designation = designation;
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entitee)) {
            return false;
        }
        Entitee other = (Entitee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
