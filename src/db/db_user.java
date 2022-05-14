
package db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author SURAJ
 */
public class db_user {
	public static void createNewTable(Connection c,String s) {    
        String sql = "CREATE TABLE IF NOT EXISTS MOVIES (\n"  
                + " Moive_Name text NOT NULL,\n"  
                + " Actor_Name text NOT NULL,\n"
                + " Actress_Name text NOT NULL,\n"
                + " Year_Of_Release integer NOT NULL,\n"
                + " Director_Name text NOT NULL\n"
                + ");";  
        try{    
            Statement stmt = c.createStatement();  
            stmt.execute(sql);  
            System.out.println("Table Created");
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }
	public static void insert(Connection conn,String a, String b, String c, String d, String f) 
	{  
        String sql = "INSERT INTO MOVIES(Moive_Name , Actor_Name, "
        		+ "Actress_Name, Year_Of_Release, Director_Name) VALUES(?,?,?,?,?)";  
   
        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, a);
            pstmt.setString(2, b);
            pstmt.setString(3, c);
            pstmt.setInt(4, Integer.parseInt(d));
            pstmt.setString(5, f);
            pstmt.executeUpdate();  
            System.out.println("Data Inserted");
        } catch (Exception e) {  
            System.out.println(e.getMessage());  
        }  
    }
	
	public void selectAll(Connection conn){  
        String sql = "SELECT * FROM MOVIES";  
          
        try {    
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) {  
                System.out.println(rs.getString("Moive_Name") + "\t" +
                		rs.getString("Actor_Name") + "\t" +
                		rs.getString("Actress_Name") + "\t" +
                		rs.getString("Year_Of_Release") + "\t" +
                		rs.getString("Director_Name"));  
            }  
        } catch (Exception e) {  
            System.out.println(e.getMessage());  
        }  
    }
	
	public void selectMovie(Connection c,String s){  
        String sql = "SELECT Moive_Name FROM MOVIES where Actor_Name is '"+s+"'";  
          
        try {    
            Statement stmt  = c.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);   
            while (rs.next()) {  
                System.out.println(rs.getString("Moive_Name"));  
            }  
        } catch (Exception e) {  
            System.out.println(e.getMessage());  
        }  
    }
}
