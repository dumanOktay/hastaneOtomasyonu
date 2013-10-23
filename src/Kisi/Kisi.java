/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kisi;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author oktay
 */
@Entity
public class Kisi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    String tc_kimlik;
    String ad;
    String soyad;
    String SSN;
    String adres;
    String tel;
    int maas;

    public Kisi() {
    }

    public Kisi(String tc_kimlik, String ad, String soyad, String SSN, String adres, String tel, int maas) {
        this.tc_kimlik = tc_kimlik;
        this.ad = ad;
        this.soyad = soyad;
        this.SSN = SSN;
        this.adres = adres;
        this.tel = tel;
        this.maas = maas;
    }

    public Kisi(int id, String tc_kimlik, String ad, String soyad, String SSN, String adres, String tel, int maas) {
        this.id = id;
        this.tc_kimlik = tc_kimlik;
        this.ad = ad;
        this.soyad = soyad;
        this.SSN = SSN;
        this.adres = adres;
        this.tel = tel;
        this.maas = maas;
    }

    public String getTc_kimlik() {
        return tc_kimlik;
    }

    public void setTc_kimlik(String tc_kimlik) {
        this.tc_kimlik = tc_kimlik;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
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
        if (!(object instanceof Kisi)) {
            return false;
        }
        Kisi other = (Kisi) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Kisi.Kisi[ id=" + id + " ]";
    }
    
}
