package CONTROLLER_SERVLET;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_SERVICE.Common.Java.CommonJava;
import POJO_MODEL.IndividualFunction;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String code = request.getParameter("code");
		int type =  Integer.parseInt(request.getParameter("type"));
		int language =  Integer.parseInt(request.getParameter("language"));
		PrintWriter out= response.getWriter();

		
		
		String[] stArray = code.split("\\r?\\n"); // split on new lines
		int x = stArray.length;
		int y;

		 for(y=0;y<x;y++) {
			 
			 out.println("Line " + y + "  : " + stArray[y]);
			 
		 }
		 
		 ArrayList<IndividualFunction> allFunctions = 	CommonJava.divideToFunctions(stArray); // Calling the method
		 for(y=0; y<allFunctions.size();y++) {
		 		IndividualFunction f2 = allFunctions.get(y);
		 		out.println(f2.getStart());
		 		out.println(f2.getEnd());
		 		out.println(f2.getMethodName());
		 	}
		 	
		 	
		 
	}
	
	
	
}
