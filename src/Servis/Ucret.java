/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servis;

import Kisi.DoktorDurum;
import Kisi.Hasta;
import VeriTabani.Veritabani;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author oktay
 */
@Entity
public class Ucret implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private int ucretTutar;
    
    private int yansimisTutar;
    
    @OneToOne
    Hasta hasta;

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

    public int getUcretTutar() {
        return ucretTutar;
    }

    public void setUcretTutar(int ucretTutar) {
        this.ucretTutar = ucretTutar;
    }

    public int getYansimisTutar() {
        Double katma=0.7;
      if(getHasta()!=null){
            if(getHasta().getKisi().getSSN().equals("SSK")){
            katma=0.5;
        }
      }
        Double tuDouble=getUcretTutar()*katma;
        return tuDouble.intValue();
    }

    public void setYansimisTutar(int yansimisTutar) {
        this.yansimisTutar = yansimisTutar;
    }
    
    public void ekle(int tutar){
        ucretTutar=this.getUcretTutar()+tutar;
        Veritabani.merge(this);
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ucret)) {
            return false;
        }
        Ucret other = (Ucret) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public Hasta getHasta() {
        return hasta;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
       
    }
    
    public int ucretHesapla(){
       return this.getHasta().getPoliklinik().getUcretTutar();
    }
    
    /*public int sosyalGuvence(){
        switch(getHasta().getKisi().getSSN()){
            case "SSK":{
                return 1;
              break;}
                default:
                    return 0;
        }
        return 0;
        
       */
    

    @Override
    public String toString() {
        return "Servis.Ucret[ id=" + id + " ]";
    }
    
}
