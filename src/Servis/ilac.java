/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servis;

import Kisi.Doktor;
import Kisi.Hasta;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author oktay
 */
@Entity
public class ilac implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String ad;
    String sonKullanimTarih;
       
    @OneToOne
    Malzeme  malzeme;
    
    @ManyToOne
    Hasta hasta;
    
    @ManyToOne
    Doktor doktor;

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSonKullanimTarih() {
        return sonKullanimTarih;
    }

    public void setSonKullanimTarih(String sonKullanimTarih) {
        this.sonKullanimTarih = sonKullanimTarih;
    }

    public Malzeme getMalzeme() {
        return malzeme;
    }

    public void setMalzeme(Malzeme malzeme) {
        this.malzeme = malzeme;
    }
    
   
    public Hasta getHasta() {
        return hasta;
    }
    
    /*
     Sağlıklı bir JPA veritabanı ilişkisinde
     * ctrl ye bastığında bi döngü içine girmen lazım hacı 
     */

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
        hasta.addilac(this);
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
        doktor.addilac(this);
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
        if (!(object instanceof ilac)) {
            return false;
        }
        ilac other = (ilac) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getAd();
    }
    
}
