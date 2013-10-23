/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kisi;

import Servis.Izin;
import Servis.Poliklinik;
import Servis.Servis;
import Servis.Tetkik;
import Servis.ilac;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author oktay
 */
@Entity
public class Doktor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String ad;
    private String sifre;
    
     int ucretTutar;

    
    @OneToMany
    List<DoktorDurum> doktorDurums;
    
    @OneToMany
    List<Hastalik> hastalikList;
    
    @OneToMany
    List<ilac> ilacList;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Kisi kisi;
    @ManyToMany
    private Collection<Hasta> hastas;
    
    @ManyToOne
    private Poliklinik poliklinik;
    
    @ManyToOne
    private  Servis servis;
    
    @OneToMany
    List<Izin> izinList;
    
    @OneToMany
    private List<Tetkik> tetkiks;
    /*
     Her doktorun birden çok hastası olabilu
     * her hastanında birden çok doktaru olabilir 
     * onçun many to many tamam mı sarı :D
     */
   
    
   

    public Doktor() {
        hastas= new ArrayList<Hasta>();
        doktorDurums=new ArrayList<>();
        ilacList=new ArrayList<>();
        hastalikList=new ArrayList<>();
        izinList= new ArrayList<>();
        tetkiks=new ArrayList<>();
    }

    public void setIzinList(List<Izin> izinList) {
        this.izinList = izinList;
    }

    public List<Izin> getIzinList() {
        return izinList;
    }

    public void addIzin(Izin izin){
        if(!getIzinList().contains(izin)){
            getIzinList().add(izin);
            izin.setDoktor(this);
        }
    }

    public int getUcretTutar() {
        return ucretTutar;
    }

    public void setUcretTutar(int ucretTutar) {
        this.ucretTutar = ucretTutar;
    }
    
    
    public void setServis(Servis servis) {
        this.servis = servis;
    }

    public Servis getServis() {
        return servis;
    }
    
    public void setIlacList(List<ilac> ilacList) {
        this.ilacList = ilacList;
    }

    public List<ilac> getIlacList() {
        return ilacList;
    }
    
    public void addilac(ilac ila){
        if(!getIlacList().contains(ila)){
            getIlacList().add(ila);
            ila.setDoktor(this);
        }
    }

    public List<Tetkik> getTetkiks() {
        return tetkiks;
    }

    public void setTetkiks(List<Tetkik> tetkiks) {
       
        this.tetkiks = tetkiks;
    }
    
    public void addTetkik(Tetkik t){
        if(!getTetkiks().contains(t)) {
            getTetkiks().add(t);
            t.setDoktor(this);
        }
    }
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getSifre() {
        return sifre;
    }
    
    
    
    public String getPass() {
        return sifre;
    }

    public void setPass(String pass) {
        this.sifre = pass;
    }

    public void setHastalikList(List<Hastalik> hastalikList) {
        this.hastalikList = hastalikList;
    }

    public List<Hastalik> getHastalikList() {
        return hastalikList;
    }
    
    public void addHastalik(Hastalik hastalik){
        if(!getHastalikList().contains(hastalik)){
            getHastalikList().add(hastalik);
            hastalik.setDoktor(this);
        }
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
        dd.setDoktor(this);
    }
        
  }

    public Collection<Hasta> getHastas() {
        return hastas;
    }

    public void setHastas(Collection<Hasta> hastas) {
        this.hastas = hastas;
    }
    
    public void addHasta(Hasta hasta){
        if(!getHastas().contains(hasta)){
            System.out.println("hasta eklendi hasta id ="+hasta.getId());
            getHastas().add(hasta);
        }
        if(!hasta.getDoktors().contains(this)){
            hasta.getDoktors().add(this);
        }
    }
    

    public Poliklinik getPoliklinik() {
        return poliklinik;
    }

    public void setPoliklinik(Poliklinik poliklinik) {
        this.poliklinik = poliklinik;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    public Kisi getKisi() {
        return kisi;
    }
    
    

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
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
        if (!(object instanceof Doktor)) {
            return false;
        }
        Doktor other = (Doktor) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getKisi().getAd() +"  "+this.getKisi().getSoyad();
    }
    
}
