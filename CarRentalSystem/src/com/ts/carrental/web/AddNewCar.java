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
import com.ts.carrental.dao.CustomerDao;
import com.ts.carrental.dto.Car;
import com.ts.carrental.dto.Customer;
import com.ts.carrental.dto.Rent;


@WebServlet("/AddNewCar")
public class AddNewCar extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String carModel = request.getParameter("carModel");
		String carColor = request.getParameter("carColor");
		int capacity = Integer.parseInt(request.getParameter("capacity"));
		int basePrice = Integer.parseInt(request.getParameter("basePrice"));
		int costPerKm = Integer.parseInt(request.getParameter("costPerKm"));
		int penality = Integer.parseInt(request.getParameter("penality"));
		String image = request.getParameter("image");
		String status = "available";
		Car car = new Car(carModel,carColor,status,capacity,basePrice,costPerKm,penality,image);
		CarDao carDao = new CarDao();
		int x = carDao.register(car);
		out.println("<h3><CENTER>Car Added Successfully...<CENTER></H3>");
		RequestDispatcher rd = request.getRequestDispatcher("AdminHome.html");
		rd.include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
