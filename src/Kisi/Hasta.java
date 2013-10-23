/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kisi;

import Servis.Oda;
import Servis.Poliklinik;
import Servis.Servis;
import Servis.Tedavi;
import Servis.Tetkik;
import Servis.Ucret;
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
public class Hasta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    String saat;
    String aciklama;
   
    String tarih;
    
    @ManyToMany
    private Collection<Doktor> doktors;
    private String ad;
    
    @OneToOne (cascade = CascadeType.ALL)
    private Kisi kisi;
    
    @OneToMany
    List<DoktorDurum> doktorDurums;
    
    @OneToMany
    List<Hastalik> hastalikList;
    
     @OneToMany
    List<ilac> ilacList;
    
    @ManyToOne
    private Poliklinik poliklinik;
    
    @ManyToOne
    private Servis servis;
    
    @OneToOne
    HastaBilgi hastaBilgi;
    
    @OneToMany
    private List<Tetkik> tetkiks;
    
    @OneToMany
    private List<Tedavi> tedaviList;
    
    @OneToOne
    Ucret ucret;
    
    @ManyToOne
    Oda oda;
    
      public Hasta() {
        doktors= new ArrayList<>();
        doktorDurums= new  ArrayList<>();
        ilacList= new ArrayList<>();
        hastalikList=new ArrayList<>();
        tedaviList=new ArrayList<>();
       
    }

    public Oda getOda() {
        return oda;
    }

    public void setOda(Oda oda) {
        this.oda = oda;
    }

      
    
    public List<Tedavi> getTedaviList() {
        return tedaviList;
    }

    public void setTedaviList(List<Tedavi> tedaviList) {
        this.tedaviList = tedaviList;
    }
      
      public void addTedavi(Tedavi tedavi){
          if(!getTedaviList().contains(tedavi)){
              getTedaviList().add(tedavi);
              tedavi.setHasta(this);
          }
          
      }

    public void setServis(Servis servis) {
        this.servis = servis;
        this.getUcret().ekle(servis.getUcretTutar());
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
            ila.setHasta(this);
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
            t.setHasta(this);
            this.getUcret().ekle(t.getUcretTutar());
        }
    }

    public void setHastaBilgi(HastaBilgi hastaBilgi) {
        this.hastaBilgi = hastaBilgi;
    }

    public HastaBilgi getHastaBilgi() {
        return hastaBilgi;
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
            hastalik.setHasta(this);
        }
    }
    public Poliklinik getPoliklinik() {
        return poliklinik;
        
    }

    public void setPoliklinik(Poliklinik poliklinik) {
        this.poliklinik = poliklinik;
        getUcret().ekle(poliklinik.getUcretTutar());
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
        dd.setHasta(this);
    }
       
    }
    
    public Collection<Doktor> getDoktors() {
        return doktors;
    }

    public void setDoktors(Collection<Doktor> doktors) {
        this.doktors = doktors;
    }
    
  
    
    public void addDoktor(Doktor doktor){
        if(!getDoktors().contains(doktor)){
             System.out.println("hasta eklendi hasta id ="+this.getId());
            getDoktors().add(doktor);
            getUcret().ekle(doktor.getUcretTutar());
        }
        
        if(!doktor.getHastas().contains(this)){
            System.out.println("Toktor eklendi  "+doktor.getKisi().getAd());
           doktor.getHastas().add(this);
        }
        
    }
    
    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Ucret getUcret() {
        return ucret;
    }

    public void setUcret(Ucret ucret) {
        this.ucret = ucret;
    }

    

   
    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
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
        if (!(object instanceof Hasta)) {
            return false;
        }
        Hasta other = (Hasta) object;
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
