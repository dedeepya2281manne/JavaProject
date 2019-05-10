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

import com.ts.carrental.dao.CustomerDao;
import com.ts.carrental.dto.Customer;

@WebServlet("/DisplayAllCustomers")
public class DisplayAllCustomers extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		CustomerDao customerDao = new CustomerDao();
		List<Customer> arrayList = customerDao.getAllCustomers();

		request.setAttribute("customersData", arrayList);
		RequestDispatcher rd = request.getRequestDispatcher("DisplayAllCustomers.jsp");
		rd.forward(request, response);		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
