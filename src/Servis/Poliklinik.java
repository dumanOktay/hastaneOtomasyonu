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
public class Poliklinik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ad;
    
    int ucretTutar;
    
    @OneToMany(mappedBy = "poliklinik")
    private List<Hasta> hastas;
    
    @OneToMany
    List<DoktorDurum> doktorDurums;
    
    @OneToMany(mappedBy = "poliklinik")
    private List<Doktor> doktors;
    
    @OneToMany(mappedBy = "poliklinik")
    private List<Depo> depoList;

    public Poliklinik() {
        doktors= new ArrayList<Doktor>();
        hastas= new ArrayList<Hasta>();
        doktorDurums= new ArrayList<DoktorDurum>();
        depoList= new ArrayList<>();
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
            depo.setPoliklinik(this);
        }
    }

    public int getUcretTutar() {
        return ucretTutar;
    }

    public void setUcretTutar(int ucretTutar) {
        this.ucretTutar = ucretTutar;
    }
    
    

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
    
    
    
    public List<Doktor> getDoktors() {
        return doktors;
    }

    public void setDoktors(List<Doktor> doktors) {
        this.doktors = doktors;
    }
    
    public void addDoktor(Doktor doktor){
        if(!getDoktors().contains(doktor)){
        getDoktors().add(doktor);
    }
        doktor.setPoliklinik(this);
    }

    public List<Hasta> getHastas() {
        return hastas;
    }

    public void setHastas(List<Hasta> hastas) {
        this.hastas = hastas;
    }
    
    public void addHasta(Hasta hasta){
        if(!getHastas().contains(hasta)){
            getHastas().add(hasta);
        }
        hasta.setPoliklinik(this);
    }

    public List<DoktorDurum> getDoktorDurums() {
        return doktorDurums;
    }

    public void setDoktorDurums(List<DoktorDurum> doktorDurums) {
        this.doktorDurums = doktorDurums;
    }
    
    
    
    public void addDurum(DoktorDurum dd){
        if(!getDoktorDurums().contains(dd)){
        getDoktorDurums().add(dd);
        dd.setPoliklinik(this);
    }
        
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
        if (!(object instanceof Poliklinik)) {
            return false;
        }
        Poliklinik other = (Poliklinik) object;
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
