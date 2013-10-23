/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servis;

import VeriTabani.Veritabani;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author oktay
 */
@Entity
public class Malzeme implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    MalzemeTur tur;
    
    
    int sayisi;
    
    @ManyToOne
    Depo depo;

    public void setTur(MalzemeTur tur) {
        this.tur = tur;
    }

    public MalzemeTur getTur() {
        return tur;
    }

    
    
    public void setDepo(Depo depo) {
        this.depo = depo;
        depo.getMalzemeList().add(this);
    }

    public Depo getDepo() {
        return depo;
    }
  

    public int getSayisi() {
        return sayisi;
    }

    public void setSayisi(int sayisi) {
        this.sayisi = sayisi;
    }
    
    public void azalt(int k){
        this.sayisi=this.sayisi-k;
        Veritabani.merge(this);
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
        if (!(object instanceof Malzeme)) {
            return false;
        }
        Malzeme other = (Malzeme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getTur().getAd();
    }
    
}
