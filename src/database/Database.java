
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database {

    
    public static void main(String[] args) {
        
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            
            con = DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "hr", "inf5180");
            
            String sql = "SELECT COUNTRY_ID,COUNTRY_NAME,REGION_NAME FROM COUNTRIES INNER JOIN REGIONS ON COUNTRIES.REGION_ID=REGIONS.REGION_ID";
            
             stm = con.createStatement();
            
             rs = stm.executeQuery(sql);
            
            
            String Cid,Cname,Rname;
            while(rs.next()){
                
                Cid = rs.getString("COUNTRY_ID");
                Cname = rs.getString("COUNTRY_NAME");
                 Rname = rs.getString("REGION_NAME");
                
                System.out.println(Cid+"-"+Cname+"-"+Rname);
                
            }
           
                
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(rs!=null){
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            if(stm!=null){
            try {
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            if(con!=null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
        
    }
    
}
