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
import javax.servlet.http.HttpSession;

import com.ts.carrental.dao.RentDao;
import com.ts.carrental.dto.Rent;


@WebServlet("/BookingHistoryOfCustomer")
public class BookingHistoryOfCustomer extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
	    int cId = (Integer)session.getAttribute("cId");
		RentDao rentDao = new RentDao();
		List<Rent> arrayList = rentDao.getPreviousBookedCars(cId,"not paid");
		request.setAttribute("rentsData", arrayList);
		RequestDispatcher rd = request.getRequestDispatcher("BookingHistory.jsp");
		rd.forward(request, response);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
