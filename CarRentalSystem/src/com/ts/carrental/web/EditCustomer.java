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


@WebServlet("/EditCustomer")
public class EditCustomer extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("<html>");
			HttpSession session = request.getSession(false);
			int cId = (int)(session.getAttribute("cId"));
			CustomerDao customerDao =  new CustomerDao();
			Customer customer = customerDao.getCustomer(cId);
			request.setAttribute("customer", customer);
			RequestDispatcher rd = request.getRequestDispatcher("EditCustomer.jsp");
			rd.include(request, response);
			out.println("</body>");
			out.println("</html>");
		
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
