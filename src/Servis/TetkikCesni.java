/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servis;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author oktay
 */
@Entity
public class TetkikCesni implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String ad;
    
    @ManyToOne
    Tetkik tetkik;

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getAd() {
        return ad;
    }

    public void setTetkik(Tetkik tetkik) {
        this.tetkik = tetkik;
        tetkik.addTetkikCesni(this);
    }

    public Tetkik getTetkik() {
        return tetkik;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof TetkikCesni)) {
            return false;
        }
        TetkikCesni other = (TetkikCesni) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servis.TetkikCesni[ id=" + id + " ]";
    }
    
}
