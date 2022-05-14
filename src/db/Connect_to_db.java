
package db;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author SURAJ
 */
public class Connect_to_db {
    public static Connection connect(String s) {  
        Connection conn = null;  
        try {  
            conn = DriverManager.getConnection(s);  
            System.out.println("Connection to SQLite has been established.");  
            return conn;  
        } catch (Exception e) {
        	System.out.println("Error establishing connection to DB");
            return null;  
        }
    }  
}