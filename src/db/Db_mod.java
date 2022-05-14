package db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

/**
 *
 * @author SURAJ
 */
public class Db_mod {
	public static void createNewDatabase(String fileName) {  
    	Connection c;
        String url = "jdbc:sqlite:C:/sqlite3/" + fileName;  
   
        try {  
            c = DriverManager.getConnection(url);  
            if (c != null) {  
                DatabaseMetaData meta = c.getMetaData();  
                System.out.println("A new database has been created with name "+fileName);  
            }  
   
        } catch (Exception e) {
        	System.out.println("Error creating new DB");
        }  
    }
}
