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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ts.carrental.dao.CarDao;
import com.ts.carrental.dao.RentDao;
import com.ts.carrental.dto.Car;
import com.ts.carrental.dto.Rent;


@WebServlet("/PayBasePrice")
public class PayBasePrice extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		int carNo = Integer.parseInt((String) session.getAttribute("carNo"));
		String rentDate1 = request.getParameter("rentDate");
		String returnDate1 = request.getParameter("returnDate");
		Date rentDate2 = null;
		
		try {
			rentDate2 = new SimpleDateFormat("yyyy-MM-dd").parse(rentDate1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date returnDate2 = null;
		try {
			returnDate2 = new SimpleDateFormat("yyyy-MM-dd").parse(returnDate1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date  rentDate = new java.sql.Date(rentDate2.getTime());
		java.sql.Date  returnDate = new java.sql.Date(returnDate2.getTime());
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateTime.format(df));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date currentDate = new java.sql.Date(date.getTime());
		if(rentDate.before(currentDate) || returnDate.before(rentDate)){
			RequestDispatcher rd = request.getRequestDispatcher("AskDate.jsp");
			rd.include(request, response);
			out.println("<h3><CENTER>Please enter valid dates....</CENTER></H3>");
		}
		else{
			session.setAttribute("rentDate", rentDate);
			session.setAttribute("returnDate", returnDate);
			int cId = (int) session.getAttribute("cId");
			CarDao carDao = new CarDao();
			Car car = carDao.getCar(carNo);	
		    int amount =  car.getBasePrice();
		   RequestDispatcher rd = request.getRequestDispatcher("PayBasePrice.jsp");
		   rd.include(request, response);
		   out.println("<h3><CENTER>Base Price:"+amount+"....</CENTER></H3>");
		
	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
