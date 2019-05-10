package com.ts.carrental.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.carrental.dao.CarDao;
import com.ts.carrental.dto.Car;


@WebServlet("/EditCar")
public class EditCar extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		int carNo = Integer.parseInt(request.getParameter("carNo"));
		CarDao carDao =  new CarDao();
		Car car = carDao.getCar(carNo);
		request.setAttribute("car", car);
		RequestDispatcher rd = request.getRequestDispatcher("EditCar.jsp");
		rd.include(request, response);
		out.println("</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
