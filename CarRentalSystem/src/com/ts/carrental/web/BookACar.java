package com.ts.carrental.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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


@WebServlet("/BookACar")
public class BookACar extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
	    String carNo = request.getParameter("carNo");
		session.setAttribute("carNo",carNo);
		RequestDispatcher rd = request.getRequestDispatcher("AskDate.jsp");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
