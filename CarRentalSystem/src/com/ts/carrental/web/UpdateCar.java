package com.ts.carrental.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.carrental.dao.CarDao;
import com.ts.carrental.dto.Car;

@WebServlet("/UpdateCar")
public class UpdateCar extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int carNo = Integer.parseInt(request.getParameter("carNo"));
		String carModel = request.getParameter("carModel");
		String carColor = request.getParameter("carColor");
		String status = request.getParameter("status");
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		int basePrice = Integer.parseInt(request.getParameter("basePrice"));	
		int  costPerKm= Integer.parseInt(request.getParameter("costPerKm"));
		int penality = Integer.parseInt(request.getParameter("penality"));
		String image = request.getParameter("image");
		
		Car car = new Car(carNo,carModel,carColor,status,capacity,basePrice,costPerKm,penality,image);	
		CarDao carDao = new CarDao();
		int x = carDao.update(car);
		if(x > 0){
			List<Car>arrayList = carDao.getAllCars();
			request.setAttribute("carsData", arrayList);
			RequestDispatcher rd = request.getRequestDispatcher("DisplayAllCars.jsp");
			rd.include(request, response);
		    out.println("<h3><CENTER>Update Success .."+x+" Rows Updated...</CENTER></H3>");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
