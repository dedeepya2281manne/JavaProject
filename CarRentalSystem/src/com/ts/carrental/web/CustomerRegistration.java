package com.ts.carrental.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.carrental.dao.CustomerDao;
import com.ts.carrental.dto.Customer;
import com.ts.carrental.dto.Rent;





@WebServlet("/CustomerRegistration")
public class CustomerRegistration extends HttpServlet {
	
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String cName = request.getParameter("cName");
		String cEmailid  = request.getParameter("cEmailid");
		String cUsername = request.getParameter("cUsername");
		String cPassword = request.getParameter("cPassword");
		String cAddress = request.getParameter("cAddress");
		String cPhoneno = request.getParameter("cPhoneno");
		String cLicenseNo = request.getParameter("cLicenseNo");
		Customer customer = new Customer(cName,cPhoneno,cEmailid,cUsername,cPassword,cAddress,cLicenseNo);
		CustomerDao customerDao = new CustomerDao();
		int x = customerDao.register(customer);
		out.println("<h3 text-color=white><CENTER>Registration Success ...<CENTER></H3>");
		RequestDispatcher rd = request.getRequestDispatcher("Main.html");
		rd.include(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
