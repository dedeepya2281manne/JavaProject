package com.ts.carrental.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
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
import com.ts.carrental.dao.CustomerDao;
import com.ts.carrental.dao.RentDao;
import com.ts.carrental.dto.Car;
import com.ts.carrental.dto.Customer;
import com.ts.carrental.dto.Rent;

@WebServlet("/CalculateCostAndUpdate")
public class CalculateCostAndUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int meterReading = Integer.parseInt(request.getParameter("meterReading"));
		HttpSession session = request.getSession(false);
		session.setAttribute("meterReading", meterReading);
		int receiptNo = Integer.parseInt((String) (session.getAttribute("receiptNo")));
		
		RentDao rentDao = new RentDao();
		Rent rent = rentDao.getRent(receiptNo);
		
		Date returnDate1 = rent.getReturnDate();
		
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateTime.format(df));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date returnDate = new java.sql.Date(date.getTime());
		int amount = 0, penality = 0;
		String s = "";
		session.setAttribute("returnDate", returnDate);
        if (returnDate.after(returnDate1)) {
			long diff = (returnDate.getTime() - returnDate1.getTime());
			int days = (int) (diff/(86400000));
			Car car = rent.getCar();
			penality =days *  car.getPenality();
			s += "You have to pay penalty for late return";
        	
        }
        if(meterReading-30 > 0) {
        	amount = rent.getCostPerKm() * (meterReading-30);
        }
        session.setAttribute("amount", amount+rent.getAmount()+penality);
        if(amount+penality > 0){
		RequestDispatcher rd = request.getRequestDispatcher("Payment.jsp");
		rd.include(request, response);
		out.println("<h3><CENTER>"+s+"</CENTER></H3>");
		out.println("<h3><center>amount : "+amount+" , penality :"+penality+"</center></h3>");
		out.println("<h3><center>Total Fair : "+(amount+penality)+"</center></h3>");
        }
        else{
        	RequestDispatcher rd = request.getRequestDispatcher("Payment.jsp");
    		rd.include(request, response);
    	    out.println("<h3><CENTER>Total Fair:0 ....</CENTER></H3>");
        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
