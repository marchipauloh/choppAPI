package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectorMySQL {

	public Connection connect(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection("jdbc:mysql://ui0tj7jn8pyv9lp6.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/tsn6peskkj3le2hn", "l8vuv0sfazzybkuy", "tsy9v55n8lvv6kcn");

		}catch(Exception e){
			throw new Error(e);
		}
	}
																					
	public boolean close(Connection connection){
		
		try{
			connection.close();
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
