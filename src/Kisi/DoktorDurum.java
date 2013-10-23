/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kisi;

import Servis.Poliklinik;
import Servis.Zaman;
import java.io.Serializable;
import javax.persistence.CascadeType;
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
public class DoktorDurum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    String saat;
    String tarih;
    
    @ManyToOne
    Hasta hasta;
    
    @OneToOne(cascade = CascadeType.ALL)
    Zaman zaman;
    
    @ManyToOne
    Doktor doktor;
    
    @ManyToOne
    Poliklinik poliklinik;

    public Zaman getZaman() {
        return zaman;
    }

    public void setZaman(Zaman zaman) {
        this.zaman = zaman;
    }

    
    
    public Hasta getHasta() {
        return hasta;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
        hasta.addDurum(this);
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public Poliklinik getPoliklinik() {
        return poliklinik;
    }

    public void setPoliklinik(Poliklinik poliklinik) {
        this.poliklinik = poliklinik;
        poliklinik.addDurum(this);
                
    }

    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DoktorDurum)) {
            return false;
        }
        DoktorDurum other = (DoktorDurum) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getHasta().toString();
    }
    
}
