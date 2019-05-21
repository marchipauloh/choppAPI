package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import model.Product;

public class ProductDB {
	
	public ArrayList<Product> selectAllProduct() {
		
		ArrayList<Product> arrayListProduct = new ArrayList<>();
		
		try {
			
			ConectorMySQL cms = new ConectorMySQL();
			Connection conn = cms.connect();
			
			PreparedStatement query = (PreparedStatement) conn.prepareStatement("SELECT * from product");
			ResultSet rs = query.executeQuery();
			
			while(rs.next()){
				
				Product product = new Product();	
				product.setId(Integer.parseInt(rs.getString("id")));
				product.setName(rs.getString("name"));
				product.setBrand(rs.getString("brand"));
				product.setCategoryCode(Integer.parseInt(rs.getString("categoryCode")));
				
				arrayListProduct.add(product);				
			}
			query.close();
			cms.close(conn);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return arrayListProduct;
		}		
	}