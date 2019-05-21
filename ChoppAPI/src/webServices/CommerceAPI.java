package webServices;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import database.CommerceDB;
import model.Commerce;


@WebServlet("/commerceAPI")
public class CommerceAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CommerceAPI() {
        super();
       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CommerceDB commerceDB = new CommerceDB();
		ArrayList<Commerce> arrayListCommerce = commerceDB.selectAllCommerce();
		String json = new Gson().toJson(arrayListCommerce);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
