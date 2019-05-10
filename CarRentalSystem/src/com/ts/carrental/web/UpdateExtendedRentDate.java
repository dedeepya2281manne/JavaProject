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

import com.ts.carrental.dao.RentDao;
import com.ts.carrental.dto.Rent;


@WebServlet("/UpdateExtendedRentDate")
public class UpdateExtendedRentDate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		int receiptNo = Integer.parseInt((String) (session.getAttribute("receiptNo")));
		RentDao rentDao = new RentDao();
		Rent rent = rentDao.getRent(receiptNo);
		String returnDate1 = request.getParameter("returnDate");
		Date returnDate2 = null;
		try {
			returnDate2 = new SimpleDateFormat("yyyy-MM-dd").parse(returnDate1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
		Date rentDate = rent.getRentDate();
		
		if(returnDate.after(currentDate) && returnDate.after(rentDate)){
			rent.setReturnDate(returnDate);
			rentDao.update(rent);
			RequestDispatcher rd = request.getRequestDispatcher("CustomerHome.jsp");
			rd.include(request, response);
		    out.println("<h3><CENTER>Return Date Altered....</CENTER></H3>");
			
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("AskExtensionDate.jsp");
			rd.include(request, response);
			out.println("<h3><CENTER>Please enter valid date....</CENTER></H3>");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
