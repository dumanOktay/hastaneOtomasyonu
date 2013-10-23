/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servis;

import Kisi.Doktor;
import Kisi.Hasta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author oktay
 */
@Entity
public class Tetkik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String ad;
      int ucretTutar;
    
    @OneToMany
    List<TetkikCesni> tetkikCesniList;
    
    @ManyToOne
    Doktor doktor;
    
    @ManyToOne
    Hasta hasta;

    public Tetkik() {
        tetkikCesniList= new ArrayList<>();
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

     public void addTetkikCesni(TetkikCesni tetkikCesni){
       if(!getTetkikCesniList().contains(tetkikCesni)){
           getTetkikCesniList().add(tetkikCesni);
           tetkikCesni.setTetkik(this);
       }
   }
    public void setTetkikCesniList(List<TetkikCesni> tetkikCesniList) {
        this.tetkikCesniList = tetkikCesniList;
    }

    public List<TetkikCesni> getTetkikCesniList() {
        return tetkikCesniList;
    }

    public Hasta getHasta() {
        return hasta;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
        hasta.addTetkik(this);
    }
    
    
    
  
    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
        doktor.addTetkik(this);
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public void setUcretTutar(int ucretTutar) {
        this.ucretTutar = ucretTutar;
    }

    public int getUcretTutar() {
        return ucretTutar;
    }

    
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tetkik)) {
            return false;
        }
        Tetkik other = (Tetkik) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getAd();
    }
    
}
