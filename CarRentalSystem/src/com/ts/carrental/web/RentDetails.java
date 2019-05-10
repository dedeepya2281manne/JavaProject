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

import com.ts.carrental.dao.RentDao;
import com.ts.carrental.dto.Car;
import com.ts.carrental.dto.Rent;

@WebServlet("/RentDetails")
public class RentDetails extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();	
		RentDao rentDao = new RentDao();
		List<Rent> arrayList = rentDao.getAllRents();
		request.setAttribute("rentsData", arrayList);
		if(arrayList.isEmpty()){
			System.out.println("EMPTY");
		}
		else{
			System.out.println("NOT EMPTY");
		}
		RequestDispatcher rd = request.getRequestDispatcher("RentDetails.jsp");
		rd.forward(request, response);		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
