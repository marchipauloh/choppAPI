package webServices;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import database.CustomerDB;
import model.Customer;


public class CustomerAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
    public CustomerAPI() {
        super();
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerDB customerDB = new CustomerDB();
		ArrayList<Customer> arrayListCustomer = customerDB.selectAllCustomer();
		String json = new Gson().toJson(arrayListCustomer);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
