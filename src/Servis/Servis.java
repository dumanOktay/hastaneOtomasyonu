/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servis;

import Kisi.Doktor;
import Kisi.DoktorDurum;
import Kisi.Hasta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author oktay
 */
@Entity
public class Servis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String servis_ad;
    private  int kapasite;
    private int dolulukOrani;
    private int odaSayisi;
    
    private int ucretTutar;
    
    @OneToMany(mappedBy = "servis")
    private List<Hasta> hastas;
    
    @OneToMany
    List<DoktorDurum> doktorDurums;
    
    @OneToMany(mappedBy = "servis")
    private List<Doktor> doktors;
    
    @OneToMany
    private List<Depo> depoList;

    public Servis() {
        doktors= new ArrayList<Doktor>();
        hastas= new ArrayList<Hasta>();
    }
    
    //doktor ekeleme
     public void addDoktor(Doktor doktor){
        if(!getDoktors().contains(doktor)){
        getDoktors().add(doktor);
    }
        doktor.setServis(this);
    }
     //hasta ekleme :D
      public void addHasta(Hasta hasta){
        if(!getHastas().contains(hasta)){
            getHastas().add(hasta);
        }
        hasta.setServis(this);
    }

    public int getOdaSayisi() {
        return odaSayisi;
    }

    public void setOdaSayisi(int odaSayisi) {
        this.odaSayisi = odaSayisi;
    }

    public void setUcretTutar(int ucretTutar) {
        this.ucretTutar = ucretTutar;
    }

    public int getUcretTutar() {
        return ucretTutar;
    }

    
       public void setDepoList(List<Depo> depoList) {
        this.depoList = depoList;
    }

    public List<Depo> getDepoList() {
        return depoList;
    }
    
    public void addDepo(Depo depo){
        if(!getDepoList().contains(depo)){
            getDepoList().add(depo);
            depo.setServis(this);
        }
    }

    public String getServis_ad() {
        return servis_ad;
    }

    public void setServis_ad(String servis_ad) {
        this.servis_ad = servis_ad;
    }

    public int getKapasite() {
        return kapasite;
    }

    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
    }

    public int getDolulukOrani() {
        return dolulukOrani;
    }

    public void setDolulukOrani(int dolulukOrani) {
        this.dolulukOrani = dolulukOrani;
    }

    public List<Hasta> getHastas() {
        return hastas;
    }

    public void setHastas(List<Hasta> hastas) {
        this.hastas = hastas;
    }

    public List<DoktorDurum> getDoktorDurums() {
        return doktorDurums;
    }

    public void setDoktorDurums(List<DoktorDurum> doktorDurums) {
        this.doktorDurums = doktorDurums;
    }

    public List<Doktor> getDoktors() {
        return doktors;
    }

    public void setDoktors(List<Doktor> doktors) {
        this.doktors = doktors;
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
        if (!(object instanceof Servis)) {
            return false;
        }
        Servis other = (Servis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getServis_ad();
    }
    
}
