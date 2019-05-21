package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import model.Location;

public class LocationDB {
	

	public ArrayList<Location> selectAllLocation() {
			
	ArrayList<Location> arrayListLocation = new ArrayList<>();
	
	try {
		
		ConectorMySQL cms = new ConectorMySQL();
		Connection conn = cms.connect();
		
		PreparedStatement query = (PreparedStatement) conn.prepareStatement("SELECT * from location");
		ResultSet rs = query.executeQuery();
		
		while(rs.next()){
			
			Location location = new Location();	
			location.setIdLocation(Integer.parseInt(rs.getString("idLocation")));
			location.setCustomerId(Integer.parseInt(rs.getString("idCustomer")));
			location.setAddress(rs.getString("address"));
			location.setNumberAdress(Integer.parseInt(rs.getString("numberAdress")));
			location.setPostalCode(Integer.parseInt(rs.getString("postalCode")));
			location.setCity(rs.getString("city"));
			location.setDistrict(rs.getString("district"));
			location.setState(rs.getString("state"));
			location.setComplement(rs.getString("complement"));			
			
			arrayListLocation.add(location);			
		}
		query.close();
		cms.close(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return arrayListLocation;
	}		
}