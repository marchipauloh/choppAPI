package webServices;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import database.ProductValueDB;
import model.ProductValue;

@WebServlet("/productValueAPI")
public class ProductValueAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductValueAPI() {
        super();
       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductValueDB productValueDB = new ProductValueDB();
		ArrayList<ProductValue> arrayListProductValue = productValueDB.selectAllProductValue();
		String json = new Gson().toJson(arrayListProductValue);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
