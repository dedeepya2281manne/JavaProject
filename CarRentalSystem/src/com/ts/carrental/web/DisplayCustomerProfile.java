package com.ts.carrental.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ts.carrental.dao.CustomerDao;
import com.ts.carrental.dto.Customer;


@WebServlet("/DisplayCustomerProfile")
public class DisplayCustomerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	    HttpSession session = request.getSession();
	    int cId = (Integer)session.getAttribute("cId");
		CustomerDao customerDao = new CustomerDao();
		Customer customer = customerDao.getCustomer(cId);
		request.setAttribute("customerData", customer);	
		RequestDispatcher rd = request.getRequestDispatcher("DisplayCustomerProfile.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
