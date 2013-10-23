/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servis;

import Kisi.Doktor;
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
public class Izin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String saat;
    int gun;
    String ay;
    Boolean isGunluk;
    
    @ManyToOne
    Doktor doktor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGun() {
        return gun;
    }

    public void setGun(int gun) {
        this.gun = gun;
    }

    public String getAy() {
        return ay;
    }

    public void setAy(String ay) {
        this.ay = ay;
    }

    public Boolean getIsGunluk() {
        return isGunluk;
    }

    public void setIsGunluk(Boolean isGunluk) {
        this.isGunluk = isGunluk;
    }

    
    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
        doktor.addIzin(this);
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
        if (!(object instanceof Izin)) {
            return false;
        }
        Izin other = (Izin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if(this.getIsGunluk()){
            return this.getGun()+"   "+this.getAy()+"  tam Gün" ;
        }else{
            return this.getGun()+"   "+this.getAy()+"  "+this.getSaat() ;
        }
    }

    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }

 
    
}
