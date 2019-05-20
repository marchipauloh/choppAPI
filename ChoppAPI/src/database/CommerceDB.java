package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import model.Commerce;

public class CommerceDB {

	public ArrayList<Commerce> selectAllCommerce() {
			
		ArrayList<Commerce> arrayListCommerce = new ArrayList<>();
		
		try {
			
			ConectorMySQL cms = new ConectorMySQL();
			Connection conn = cms.connect();
			
			PreparedStatement query = (PreparedStatement) conn.prepareStatement("SELECT * from commerce");
			ResultSet rs = query.executeQuery();
			
		while(rs.next()){
				
			Commerce commerce = new Commerce();	
			commerce.setId(Integer.parseInt(rs.getString("id")));
			commerce.setIdCustomer(Integer.parseInt(rs.getString("idCustomer")));
			commerce.setIdLocation(Integer.parseInt(rs.getString("idLocation")));
			commerce.setIdTrolley(Integer.parseInt(rs.getString("idTrolley")));			
			
			arrayListCommerce.add(commerce);
			
		}
			query.close();
			cms.close(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return arrayListCommerce;
	}
}	

