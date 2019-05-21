package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import model.User;

public class UserDB {
	
	public ArrayList<User> selectAllUser() {
		
		ArrayList<User> arrayListUser = new ArrayList<>();
		
		try {
			
			ConectorMySQL cms = new ConectorMySQL();
			Connection conn = cms.connect();
			
			PreparedStatement query = (PreparedStatement) conn.prepareStatement("SELECT * from user");
			ResultSet rs = query.executeQuery();
			
			while(rs.next()){
				
				User user = new User();	
				user.setId(Integer.parseInt(rs.getString("id")));
				user.setIdCustomers(Integer.parseInt(rs.getString("idCustomers")));
				user.setCodeIMEI(Integer.parseInt(rs.getString("codeIMEI")));
				user.setDtAccess(rs.getString("dtAccess"));
				
				
				
				arrayListUser.add(user);				
			}
			query.close();
			cms.close(conn);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return arrayListUser;
		}		
	}

