/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package yazlabdeneme2;



/**
 *
 * @author suku
 */
public class Kontrol {
 
  public static boolean isNumeric(String str) {  
  try  {  
    double d = Double.parseDouble(str);  
  }  
  catch(NumberFormatException nfe) {  
    return false;  
  }  
  return true;  
    }
    
}
