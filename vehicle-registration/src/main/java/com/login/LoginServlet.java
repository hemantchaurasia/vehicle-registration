package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
@Controller
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		System.out.println("username ::" + userID);
		
		try {
			String isError = null;
			if (userID.equals("admin123") && password.equals("admin123")) {
				response.sendRedirect("admin/searchRequest.jsp");
			} else if (userID.equals("customer") && password.equals("customer123")) {
				response.sendRedirect("customer/customer.jsp");
			}
			else {
				isError = "error";
				response.sendRedirect("login.jsp?isErr="+isError);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
