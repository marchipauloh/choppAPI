package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectorMySQL {

	public Connection connect(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection("sever", "username", "password");

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
