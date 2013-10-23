/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servis;

import Kisi.Hasta;
import VeriTabani.Veritabani;
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
public class Oda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    int kapasite;
    
    String ad;
    
    int kisisay;
    
    Double dolulukOrani;
    
    
    @ManyToOne
    Servis servis;
    
    @OneToMany
    List<Hasta> hastaList;

    public Oda() {
        hastaList= new ArrayList<>();
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    
    public int getKapasite() {
        return kapasite;
    }

    public void setKapasite(int kapasite) {
        this.kapasite = kapasite;
      
    }

    public int getKisisay() {
        return kisisay;
    }

    public void setKisisay(int kisisay) {
        this.kisisay = kisisay;
    }

    public Double getDolulukOrani() {
        Double a;
        int s=getHastaList().size();
        int x=getKapasite();
        a=(double)(s/x);
        System.out.println("dolluk oarını "+getHastaList().size()+"   "+getKapasite()+"  "+a);
       // Double k=Double.parseDouble(Float.toString(a));
        return 4.5;
    }

    public void setDolulukOrani(Double dolulukOrani) {
        this.dolulukOrani = dolulukOrani;
    }

    public Servis getServis() {
        return servis;
    }

    public void setServis(Servis servis) {
        this.servis = servis;
    }

    public List<Hasta> getHastaList() {
        return hastaList;
    }

    public void setHastaList(List<Hasta> hastaList) {
        this.hastaList = hastaList;
    }

    public void addHasta(Hasta hasta){
        if(!getHastaList().contains(hasta)){
            getHastaList().add(hasta);
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
        if (!(object instanceof Oda)) {
            return false;
        }
        Oda other = (Oda) object;
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
