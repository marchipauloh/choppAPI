package webServices;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import database.BagDB;
import model.Bag;

@WebServlet("/bagAPI")
public class BagAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BagAPI() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		BagDB bagDB = new BagDB();
		ArrayList<Bag> arrayListBag = bagDB.selectAllBag();
		String json = new Gson().toJson(arrayListBag);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
