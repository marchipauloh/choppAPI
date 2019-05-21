package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import model.Trolley;

public class TrolleyDB {
	
public ArrayList<Trolley> selectAllTrolley() {
		
		ArrayList<Trolley> arrayListTrolley = new ArrayList<>();
		
		try {
			
			ConectorMySQL cms = new ConectorMySQL();
			Connection conn = cms.connect();
			
			PreparedStatement query = (PreparedStatement) conn.prepareStatement("SELECT * from trolley");
			ResultSet rs = query.executeQuery();
			
			while(rs.next()){
				
				Trolley trolley = new Trolley();	
				trolley.setId(Integer.parseInt(rs.getString("id")));
				trolley.setIdBag(Integer.parseInt(rs.getString("idBag")));
				trolley.setIdCustomerBag(Integer.parseInt(rs.getString("idCustomerBag")));
				trolley.setDiscounts(Double.parseDouble(rs.getString("discounts")));
				trolley.setFinalValue(Double.parseDouble(rs.getString("finalValue")));
								
				arrayListTrolley.add(trolley);				
			}
			query.close();
			cms.close(conn);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return arrayListTrolley;
		}		
	}