
package moviesfile;

/**
 *
 * @author SURAJ
 */
import java.sql.Connection;
import java.util.Scanner;

import db.*;
import java.sql.DriverManager;
public class MoviesFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Db_mod.createNewDatabase("movies.db");
			Connect_to_db to_db=new Connect_to_db();
			Connection conn=to_db.connect("jdbc:sqlite:C://sqlite3/movies.db");
			Scanner sc=new Scanner(System.in);
			db_user d=new db_user();
			d.createNewTable(conn, "MOVIES");
			System.out.println("Enter the number of records to insert: ");
	    	int n=sc.nextInt();
	    	sc.nextLine();
	    	while(n>0)
	    	{
	    		String q,w,e,r,y;
	    		System.out.println("Enter Moive_Name: ");
	    		q=sc.nextLine();
	    		System.out.println("Enter Actor_Name: ");
	    		w=sc.nextLine();
	    		System.out.println("Enter Actress_Name: ");
	    		e=sc.nextLine();
	    		System.out.println("Enter Year_Of_Release: ");
	    		r=sc.nextLine();
	    		System.out.println("Enter Director_Name: ");
	    		y=sc.nextLine();
	    		d.insert(conn, q, w, e, r, y);
	    		n=n-1;
	    	}
	    	d.selectAll(conn);
	    	System.out.println("Enter the Actor_Name: ");
    		String p;
	    	p=sc.nextLine();
                System.out.println("Movies based on above actor : ");
	    	d.selectMovie(conn,p);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}