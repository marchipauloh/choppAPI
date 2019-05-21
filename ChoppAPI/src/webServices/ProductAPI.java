package webServices;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import database.ProductDB;

import model.Product;

@WebServlet("/productAPI")
public class ProductAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ProductAPI() {
        super();
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductDB productDB = new ProductDB();
		ArrayList<Product> arrayListProduct = productDB.selectAllProduct();
		String json = new Gson().toJson(arrayListProduct);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
