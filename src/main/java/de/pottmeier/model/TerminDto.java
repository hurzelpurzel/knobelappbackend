/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.pottmeier.model;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ludger
 */
public class TerminDto {

    @Id
    public String id;
    public Date termin;
    public String ort;
    public String anlass;

    public TerminDto() {

    }

    public TerminDto(String id, Date termin, String ort, String anlass) {

        this(termin, ort, anlass);
        this.id = id;
    }

    public TerminDto(Date termin, String ort, String anlass) {

        this.termin = termin;
        this.ort = ort;
        this.anlass = anlass;
    }

    @Override
    public String toString() {
        return "TerminDto{" + "id=" + id + ", termin=" + termin + ", ort=" + ort + ", anlass=" + anlass + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TerminDto other = (TerminDto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
