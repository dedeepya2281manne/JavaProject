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


@WebServlet("/CustomerLogin")
public class CustomerLogin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("HIIIII...................................");
		String cUsername = request.getParameter("cUsername");
		String cPassword = request.getParameter("cPassword");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("cUsername", cUsername);
		session.setAttribute("cPassword", cPassword);

		
			CustomerDao customerDao = new CustomerDao();
			Customer customer = customerDao.getCustomer(cUsername);
			out.print("<html>");        
			if(customer != null){
				session.setAttribute("cId", customer.getcId());
				session.setAttribute("customer", customer);
				RequestDispatcher rd = request.getRequestDispatcher("CustomerHome.jsp");
				rd.forward(request, response);
			}

			else
			{
				
				RequestDispatcher rd = request.getRequestDispatcher("sample.jsp");
				rd.include(request, response);
				out.print("<body> text=white");
				out.print("<center><h1>Invalid Credentials..</h1></center>");         
			}
		out.println("</html>");        
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
