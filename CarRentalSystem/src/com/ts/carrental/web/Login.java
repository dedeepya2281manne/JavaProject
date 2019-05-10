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


@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String cUsername = request.getParameter("cUsername");
		String cPassword = request.getParameter("cPassword");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("cUsername", cUsername);
		session.setAttribute("cPassword", cPassword);

		if((cUsername.equals("admin"))&& (cPassword.equals("admin"))){
			RequestDispatcher rd = request.getRequestDispatcher("AdminHome.html");
			rd.forward(request, response);    
		}
		else 
		{   
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
				out.print("<body>");
				out.print("<center><h1>Invalid Credentials..</h1></center>");
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.include(request, response);
				out.print("</body>");            
			}
		}
		out.println("</html>");        
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
