/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servis;

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
public class Depo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    String ad;
    
    @ManyToOne
    Poliklinik poliklinik;
    
    @ManyToOne
    Servis servis;
    
    
    @OneToMany
    List<Malzeme> malzemeList;

    public Depo() {
        malzemeList=new ArrayList<>();
    }

    public Poliklinik getPoliklinik() {
        return poliklinik;
    }

    public void setPoliklinik(Poliklinik poliklinik) {
        this.poliklinik = poliklinik;
        poliklinik.addDepo(this);
        System.out.println("Ekledim daa");
    }

    public Servis getServis() {
        return servis;
    }

    public void setServis(Servis servis) {
        this.servis = servis;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    
    
    public List<Malzeme> getMalzemeList() {
        return malzemeList;
    }

    public void setMalzemeList(List<Malzeme> malzemeList) {
        this.malzemeList = malzemeList;
    }

    public void addMalzeme(Malzeme malzeme){
        if(!getMalzemeList().contains(malzeme)){
            getMalzemeList().add(malzeme);
            malzeme.setDepo(this);
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
        if (!(object instanceof Depo)) {
            return false;
        }
        Depo other = (Depo) object;
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
