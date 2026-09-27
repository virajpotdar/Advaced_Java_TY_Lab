package com.registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/pas")
public class pas extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   	String name = request.getParameter("name");
		    String rollno = request.getParameter("rollno");
		  
		    HttpSession session = request.getSession();

		    session.setAttribute("name", name);
		    session.setAttribute("rollno", rollno);
		    
		    response.sendRedirect("contact.html");
	}

}
