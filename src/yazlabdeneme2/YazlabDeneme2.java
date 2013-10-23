/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yazlabdeneme2;

import VeriTabani.Veritabani;
import gorunum.Hastane_Otomasyonu;



/**
 *
 * @author oktay
 */
public  class YazlabDeneme2 {

    /**
     * @param args the command line arguments
     */
   
    
    
    public static void main(String[] args) {
      
        
        Veritabani.onCreate();
        Hastane_Otomasyonu ho= new Hastane_Otomasyonu();
        ho.setVisible(true);
        ho.setTitle("Hastane Otamasyonu");    
     
    }
}
