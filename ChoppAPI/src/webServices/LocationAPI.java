package webServices;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import database.LocationDB;

import model.Location;

@WebServlet("/locationAPI")
public class LocationAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LocationAPI() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LocationDB locationDB = new LocationDB();
		ArrayList<Location> arrayListLocation = locationDB.selectAllLocation();
		String json = new Gson().toJson(arrayListLocation);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
