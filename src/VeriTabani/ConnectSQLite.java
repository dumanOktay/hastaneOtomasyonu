package VeriTabani;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectSQLite {
    
    static Connection connection = null;
    static ResultSet resultSet = null;
    static Statement statement = null;
    
    static Connection acikConnection = null;
    static Statement acikStatement = null;
  
    String as;
    private static ConnectSQLite selfIntance = null;
    static String PATHSQL = "jdbc:sqlite:/home/oktay/NetBeansProjects/Yazlab3/hastane_otomasyonu.sqlite";
    
    public static void openConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            acikConnection = DriverManager.getConnection(PATHSQL);
            acikStatement = acikConnection.createStatement();
            
        } catch (Exception ex) {
            Logger.getLogger(ConnectSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public static void sqlExecute(String sql) {
        try {
            
            acikStatement.executeUpdate(sql);
            
        } catch (SQLException e) {
           System.out.println("hataaaaa" + e.toString());
        }
    }
    
    public static void sqlExecute3(String sqlCom) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(PATHSQL);
            statement = connection.createStatement();
            
            statement.executeUpdate(sqlCom);
            
        } catch (Exception e) {
            System.out.println("hataaaaa" + e.toString());
            
        }
        try {
           
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void run() {
        try {
            Class.forName("org.sqlite.JDBC");
            String dirPAth = System.getProperty("hastane_otomasyonu.sqlite");
            connection = DriverManager.getConnection(PATHSQL);
            System.out.println("aaa" + dirPAth);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM kisi_info");
            while (resultSet.next()) {
                System.out.println("EMPLOYEE NAME:" + resultSet.getString("name") + "status  " + resultSet.getString("email"));
                //as=resultSet.getString("name");
             
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
  /*  
    public Doktor getDoktor(int id){
           Doktor doktor=null;
            try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(PATHSQL);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from doktor where doktor_id="+id+"");
            while (resultSet.next()) {
                //doktor=new Doktor(resultSet.getInt("doktor_id"), resultSet.getInt("maas"), resultSet.getInt("servis_id"), resultSet.getString("tc_kimlik"), resultSet.getString("ad"), resultSet.getString("soyad"), resultSet.getString("tc_kimlik"), resultSet.getString("SSN"), resultSet.getString("tel"));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                
            } catch (Exception e) {
            }
        }
        return doktor;
    }
    
   public static  List<Doktor> getDoktors(String kosul){
        
        List<Doktor> doktors= new ArrayList<Doktor>();
        Doktor doktor= null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(PATHSQL);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from doktor"+kosul);
          while (resultSet.next()) {
                doktor=new Doktor(resultSet.getInt("doktor_id"), resultSet.getInt("maas"), resultSet.getInt("servis_id"), 
                        resultSet.getString("tc"), resultSet.getString("ad"), resultSet.getString("soyad"), resultSet.getString("SSN"),
                        resultSet.getString("adres"), resultSet.getString("tel"));
            doktors.add(doktor);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                
            } catch (Exception e) {
            }
        }
        return doktors;
    }
   
   public static  void insertDoktorDurum(DoktorDurum dd){

       
       String sorgu = "insert into doktordurum (servis_id,doktor_id,gun,saat,hasta_id,durum) values(%d,%d, %d, '%s', %d, '%s')";
       sorgu = String.format(sorgu, dd.getServis_id(), dd.getDoktor_id(), dd.getGun(), dd.getSaat(),
               dd.getHasta_id(), dd.getDurum());
       System.out.println(""+sorgu);
       sqlExecute(sorgu);
       
   }
  
   public static  List<Servis> getServiss(){
        
        List<Servis> serviss= new ArrayList<Servis>();
        Servis servis= null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(PATHSQL);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from servisler");
          while (resultSet.next()) {
                servis=new Servis(resultSet.getInt("servis_id"), resultSet.getString("servis_ad"));
            serviss.add(servis);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
                
            } catch (Exception e) {
            }
        }
        return serviss;
    }
    
    public static void deleteKisi(int id) {
        sqlExecute("delete from kisi_info where id=" + id + "");
    }
*/
    
    public static ConnectSQLite newIntance() {
        selfIntance = new ConnectSQLite();
        return selfIntance;
    }
    
    public static ConnectSQLite getIntance() {
        if (selfIntance == null) {
            
            selfIntance = new ConnectSQLite();
        }
        
        return selfIntance;
    }
}
