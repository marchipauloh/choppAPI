package webServices;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import database.UserDB;
import model.User;

@WebServlet("/userAPI")
public class UserAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserAPI() {
        super();
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDB userDB = new UserDB();
		ArrayList<User> arrayListUser = userDB.selectAllUser();
		String json = new Gson().toJson(arrayListUser);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
