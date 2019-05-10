package com.ts.carrental.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ts.carrental.dao.CarDao;
import com.ts.carrental.dao.CustomerDao;
import com.ts.carrental.dao.RentDao;
import com.ts.carrental.dto.Car;
import com.ts.carrental.dto.Customer;
import com.ts.carrental.dto.Rent;

@WebServlet("/UpdateRent")
public class UpdateRent extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		int carNo = Integer.parseInt((String) session.getAttribute("carNo"));
		int cId = (int) session.getAttribute("cId");
		CarDao carDao = new CarDao();
		Car car = carDao.getCar(carNo);	
		car.setStatus("not available");
		carDao.update(car);
		CustomerDao customerDao = new CustomerDao();
		Customer customer = customerDao.getCustomer(cId);
		int meterReading = 0;
		String paid = "not paid";
		int amount =  car.getBasePrice();
		int costPerKm = car.getCostPerKm();
		java.sql.Date rentDate = (java.sql.Date) session.getAttribute("rentDate");
		java.sql.Date returnDate = (java.sql.Date) session.getAttribute("returnDate");	
		Rent rent = new Rent(rentDate, returnDate,amount, paid,meterReading,costPerKm,customer,car);
		RentDao rentDao = new RentDao();
		int x = rentDao.register(rent);
		RequestDispatcher rd = request.getRequestDispatcher("CustomerHome.jsp");
		rd.include(request, response);
	    out.println("<h3><CENTER>Booking Success....</CENTER></H3>");
		}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
