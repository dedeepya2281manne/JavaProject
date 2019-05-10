package com.ts.carrental.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.carrental.dao.CarDao;
import com.ts.carrental.dto.Car;

@WebServlet("/DisplayAllCars")
public class DisplayAllCars extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		CarDao carDao = new CarDao();
		List<Car> arrayList = carDao.getAllCars();

		request.setAttribute("carsData", arrayList);
		RequestDispatcher rd = request.getRequestDispatcher("DisplayAllCars.jsp");
		rd.forward(request, response);		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
