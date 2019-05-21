package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import model.ProductValue;

public class ProductValueDB {

public ArrayList<ProductValue> selectAllProductValue() {
		
		ArrayList<ProductValue> arrayListProductValue = new ArrayList<>();
		
		try {
			
			ConectorMySQL cms = new ConectorMySQL();
			Connection conn = cms.connect();
			
			PreparedStatement query = (PreparedStatement) conn.prepareStatement("SELECT * from productValue");
			ResultSet rs = query.executeQuery();
			
			while(rs.next()){
				
				ProductValue productValue = new ProductValue();	
				productValue.setId(Integer.parseInt(rs.getString("id")));
				productValue.setIdProduct(Integer.parseInt(rs.getString("idProduct")));
				productValue.setLitres(Double.parseDouble(rs.getString("litres")));
				productValue.setValue(Double.parseDouble(rs.getString("value")));
				
				arrayListProductValue.add(productValue);				
			}
			
			query.close();
			cms.close(conn);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return arrayListProductValue;
		}		
	}