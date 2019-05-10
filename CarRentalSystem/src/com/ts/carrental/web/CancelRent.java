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


@WebServlet("/CancelRent")
public class CancelRent extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		int receiptNo = Integer.parseInt(request.getParameter("receiptNo"));
		RentDao rentDao = new RentDao();
		Rent rent = rentDao.getRent(receiptNo);
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateTime.format(df));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date rentDate = new java.sql.Date(date.getTime());
		Date rentDate1 = rent.getRentDate();
			long diff = (rentDate1.getTime() - rentDate.getTime());
			int days = (int) (diff/(86400000));
			System.out.println("DAYS =" + days);
			if(days >= 1){
				rent.setPayment("BookingCancelled");
				rent.setAmount(0);
				rentDao.update(rent);
				Car car = rent.getCar();
				car.setStatus("available");
				CarDao carDao = new  CarDao();
				carDao.update(car);
				RequestDispatcher rd = request.getRequestDispatcher("CustomerHome.jsp");
				rd.include(request, response);
			    out.println("<h3><CENTER>Cancellation Success....</CENTER></H3>");
			    out.println("<h3><CENTER>Amount will be refunded soon....</CENTER></H3>");
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("CustomerHome.jsp");
				rd.include(request, response);
				out.println("<h3><CENTER>Cancellation Failed....</CENTER></H3>");
			    out.println("<h3><CENTER>Cancellation should be done atleast a day before rented date....</CENTER></H3>");
			}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
