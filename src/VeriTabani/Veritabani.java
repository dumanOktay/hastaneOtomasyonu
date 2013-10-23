/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VeriTabani;

import Kisi.Doktor;
import Kisi.Hasta;
import Kisi.Kisi;
import Servis.Poliklinik;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;


/**
 *
 * @author oktay
 */
public class Veritabani {
    public static EntityManagerFactory emf;
    public static EntityManager em;
    
    
    public static void persist(Object object){
        //onCreate();
        em.getTransaction().begin();
        
        try {
            em.persist(object);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(""+e.getMessage());
            em.getTransaction().rollback();
        }
        finally{
            //em.close();
        }
    }
     public static void merge(Object object){
       // onCreate();
        em.getTransaction().begin();
        
        try {
            em.merge(object);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(""+e.getMessage());
            em.getTransaction().rollback();
        }
        finally{
            //em.close();
        }
    }
    
    public static  List readObject(Object object){
       
       // onCreate();
        Query query=em.createQuery("select h from "+object.getClass().getSimpleName()+" h");
        
        return  query.getResultList();
    }
    
    public static List executeSqlCommand(Object object,String kosul){
        //onCreate();
        Query querySql=em.createQuery("select o from "+object.getClass().getSimpleName()
                +" o where o."+kosul);
        return  querySql.getResultList();
    }
    
    public static void onCreate(){
        emf=javax.persistence.Persistence.createEntityManagerFactory("YazlabDeneme2PU");
        em=emf.createEntityManager();
    }
    
    public static void addDoktorDurum(){
        List<Doktor> doktors=(List<Doktor>)readObject(new Doktor());
        List<Poliklinik> polikliniks=(List<Poliklinik>)readObject(new Poliklinik());
        for(Poliklinik p: polikliniks){
            for(Doktor d: doktors)
            {
                if(d.getPoliklinik().getId()==p.getId()){
                    System.out.println("Poli adi "+p.getAd()+"   "+d.getKisi().getAd());
                }
            }
        }
    }
    
    public static void veriEkle(){
        
        //onCreate();
        em.getTransaction().begin();
        
        
        
        
        
        em.getTransaction().commit();
        em.close();
        
    }
}

