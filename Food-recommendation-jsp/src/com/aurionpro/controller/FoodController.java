package com.aurionpro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.model.Food;


@WebServlet("/FoodController")
public class FoodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public FoodController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String c=request.getParameter("taste");
		List<String> recommendedFood=new Food().getFood(c);
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/result.jsp");
//		for(int i=0;i<recommendedFood.size();i++) {
//			out.print(recommendedFood.get(i));
//		}
		request.setAttribute("FoodList", recommendedFood);
		dispatcher.forward(request, response);
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
