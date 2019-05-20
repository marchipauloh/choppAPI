package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import model.Bag;

public class BagDB {

	public ArrayList<Bag> selectAllBag() {
		
		ArrayList<Bag> arrayListBag = new ArrayList<>();
		
		try {
			
			ConectorMySQL cms = new ConectorMySQL();
			Connection conn = cms.connect();
			
			PreparedStatement query = (PreparedStatement) conn.prepareStatement("SELECT * from bag");
			ResultSet rs = query.executeQuery();
			
			while(rs.next()){
				
				Bag bag = new Bag();
				bag.setId(Integer.parseInt(rs.getString("id")));
				bag.setAmount(Integer.parseInt(rs.getString("amount")));
				bag.setDiscounts(Double.parseDouble(rs.getString("discounts")));
				bag.setFinalValue(Double.parseDouble(rs.getString("finalValue")));
				bag.setIdCustumer(Integer.parseInt(rs.getString("idCustumer")));
				bag.setIdProduct(Integer.parseInt(rs.getString("idProduct")));
				bag.setIdProductValue(Integer.parseInt(rs.getString("idProductValue")));
				
				arrayListBag.add(bag);
			}
			
			query.close();
			cms.close(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return arrayListBag;
	}

}
