package com.registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/conts")
public class conts extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String email = request.getParameter("name");
		    String phoneno = request.getParameter("rollno");
		   

		    HttpSession session = request.getSession();

		    session.setAttribute("email", email);
		    session.setAttribute("phoneno", phoneno);
		    
		    response.sendRedirect("edu.html");
	}

}
