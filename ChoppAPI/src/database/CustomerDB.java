package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import model.Customer;

public class CustomerDB {

	public static ArrayList<Customer> selectAllCustomer() {
		
		ArrayList<Customer> arrayListCustomer = new ArrayList<>();
		
		try {
				
			ConectorMySQL cms = new ConectorMySQL();
			Connection conn = cms.connect();
			
			PreparedStatement query = (PreparedStatement) conn.prepareStatement("SELECT * from customer");
			ResultSet rs = query.executeQuery();
			
			while(rs.next()){
				
				Customer customer = new Customer();	
				customer.setId(Integer.parseInt(rs.getString("id")));
				customer.setName(rs.getString("name"));
				customer.setDtBirth(rs.getString("dtBirth"));
				customer.setCell(Integer.parseInt(rs.getString("cell")));
				customer.setTell(Integer.parseInt(rs.getString("tell")));
				customer.setEmail(rs.getString("email"));
				customer.setGender(rs.getString("gender"));
				customer.setPassoword(rs.getString("tell"));
				
				arrayListCustomer.add(customer);				
			}
			
		query.close();
		cms.close(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return arrayListCustomer;
	}		
}
