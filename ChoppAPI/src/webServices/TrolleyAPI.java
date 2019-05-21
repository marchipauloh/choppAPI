package webServices;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


import database.TrolleyDB;

import model.Trolley;

@WebServlet("/trolleyAPI")
public class TrolleyAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TrolleyAPI() {
        super();
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TrolleyDB trolleyDB = new TrolleyDB();
		ArrayList<Trolley> arrayListTrolley = trolleyDB.selectAllTrolley();
		String json = new Gson().toJson(arrayListTrolley);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
