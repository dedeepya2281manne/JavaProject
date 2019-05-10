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

@WebServlet("/DeleteCar")
public class DeleteCar extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int carNo = Integer.parseInt(request.getParameter("carNo"));
		CarDao carDao =  new CarDao();
		int x = carDao.delete(carNo);
		if(x > 0){
			List<Car>arrayList = carDao.getAllCars();
			request.setAttribute("carsData", arrayList);
			RequestDispatcher rd = request.getRequestDispatcher("DisplayAllCars.jsp");
			rd.include(request, response);
		    out.println("<h3><CENTER>Delete Success .."+x+" Rows  Deleted...</CENTER></H3>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


}
